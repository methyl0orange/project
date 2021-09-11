package com.oracle.sport.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.json.JSON;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.sport.cart.CartService;
import com.oracle.sport.commons.RequestUtils;
import com.oracle.sport.po.BuyerCart;
import com.oracle.sport.po.BuyerItem;
import com.oracle.sport.po.Sku;
import com.oracle.sport.sku.SkuService;

@Controller
public class CartController {

	@Autowired
	private SkuService skuService;
	@Autowired
	private CartService cartService;
	
	//添加购物车
	@RequestMapping("/addCart")
	public String addCart(Long sid ,Integer buyNum,String url,HttpServletRequest request,HttpServletResponse response){
		//判断用户是否登陆
		//获取cookie
		Cookie[] cs = request.getCookies();
		String csessionid = RequestUtils.getCSESSIONID(request, response);
		boolean falg = false;
		String username = null;
		for (Cookie cookie : cs) {
			if(csessionid.equals(cookie.getName())){
				falg = true;
				username = cookie.getValue();
				break;
			}
		}
		
		//如何存到redis
		if(falg){
			cartService.addBuyerCartToRedis(sid, buyNum, username);
		}
	
		//如何存到cookie中
		ObjectMapper om = new ObjectMapper();
		//不要NULL 不要转了
		om.setSerializationInclusion(Include.NON_NULL);
		
		if(!falg){
			boolean flag1 = false;
			BuyerCart bc = null;
			for (Cookie cookie : cs) {
				if("jdbuyercart".equals(cookie.getName())){
					flag1 = true;
					try {
						bc = om.readValue(cookie.getValue(), BuyerCart.class);
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			List<BuyerItem> list = null;
			if(flag1){
				//存在购物车追加商品
				list = bc.getItems();
				
			}else{
				//创建购物车
				list = new ArrayList<BuyerItem>();
			}
			
			BuyerItem bi = new BuyerItem();
			bi.setAmount(buyNum);
			Sku sku = skuService.selectByPrimaryKey(sid);
			bi.setSku(sku);
			bi.setIsHave(sku.getStock()>=buyNum);
			boolean b = false;
			for(BuyerItem buyerItem:list){
				if(buyerItem.equals(bi)){
					buyerItem.setAmount(buyerItem.getAmount()+buyNum);
					b = true;
					break;
				}
			}
			if(!b){
				list.add(bi);
			}
			//把集合转json
			StringWriter w   = new StringWriter();
			BuyerCart bc0 = new BuyerCart();
		
			try {
				bc0.setItems(list);
				om.writeValue(w, bc0);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie cookie = new Cookie("jdbuyercart", w.toString());
			cookie.setMaxAge(7*24*3600);
			response.addCookie(cookie);
			
		}
		return "redirect:"+url;
	}
	
	//toCart
	@RequestMapping("toCart")
	public String toCart(HttpServletRequest request,HttpServletResponse response,Model model){
		//判断用户是否登陆
		//获取cookie
		Cookie[] cs = request.getCookies();
		String csessionid = RequestUtils.getCSESSIONID(request, response);
		boolean falg = false;
		String username = null;
		for (Cookie cookie : cs) {
			if(csessionid.equals(cookie.getName())){
				falg = true;
				username = cookie.getValue();
				break;
			}
		}
		if(falg){
			model.addAttribute("carts",cartService.getBuyerCartFromRedis(username).getItems());
		}else{
			for (Cookie cookie : cs) {
				if("jdbuyercart".equals(cookie.getName())){
					//如何存到cookie中
					ObjectMapper om = new ObjectMapper();
					//不要NULL 不要转了
					om.setSerializationInclusion(Include.NON_NULL);
					
					try {
						model.addAttribute("carts", om.readValue(cookie.getValue(), BuyerCart.class).getItems());
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
		return "cart";
	}
}

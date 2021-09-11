package com.oracle.sport.cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import com.oracle.sport.mapper.SkuMapper;
import com.oracle.sport.po.BuyerCart;
import com.oracle.sport.po.BuyerItem;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private JedisPool jedisPool;
	
	public void addBuyerCartToRedis(Long sid, Integer count,String username) {
		Jedis jedis = jedisPool.getResource();
		Map<String, String> map = jedis.hgetAll(username);
		Set<String> keys = map.keySet();
		boolean b = false;
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			if(sid.equals(ite.next())){
				b = true;
			}
		}
		if(b){
			jedis.hincrBy(username, String.valueOf(sid), count);
		}else{
			jedis.hset(username, String.valueOf(sid), String.valueOf(count));
		}
		jedis.close();
	}
	@Autowired
    private SkuMapper skuMapper;
	public BuyerCart getBuyerCartFromRedis(String username) {
		Jedis jedis = jedisPool.getResource();
		Map<String, String> map = jedis.hgetAll(username);
		BuyerCart bc = new BuyerCart();
		List<BuyerItem> bilist = new ArrayList<BuyerItem>();
		Set<String> keys = map.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()){
			Long sid = Long.parseLong(ite.next());
			BuyerItem bi = new BuyerItem();
			bi.setAmount(Integer.parseInt(map.get(String.valueOf(sid))));
			bi.setIsHave(true);
			bi.setSku(skuMapper.selectByPrimaryKey(sid));
			bilist.add(bi);
		}
		bc.setItems(bilist);
		
		return bc;
	}

}

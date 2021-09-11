package com.oracle.sport.cart;

import com.oracle.sport.po.BuyerCart;

public interface CartService {

	public void addBuyerCartToRedis(Long sid,Integer count,String username);
	
	public BuyerCart getBuyerCartFromRedis(String username);
}

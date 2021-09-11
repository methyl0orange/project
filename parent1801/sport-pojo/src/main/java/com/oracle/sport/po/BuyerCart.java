package com.oracle.sport.po;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 购物车
 * @author lx
 *
 */
public class BuyerCart implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//1：商品结果集 List<BuyerItem> 
	private List<BuyerItem> items = new ArrayList<BuyerItem>();
	
	

	public List<BuyerItem> getItems() {
		return items;
	}

	public void setItems(List<BuyerItem> items) {
		this.items = items;
	}
	
	
	
	
}

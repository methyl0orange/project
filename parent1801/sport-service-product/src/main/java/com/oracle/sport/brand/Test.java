package com.oracle.sport.brand;

import redis.clients.jedis.Jedis;

public class Test {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.200.130", 6379);
		jedis.set("name", "hxx");
		
		String name = jedis.get("name");
		System.out.println(name);
		jedis.close();

	}

}

package com.ibeifeng.threaddemo;

/**
 * 饿汉式
 * @author 金珠文
 * 2016年12月5日
 */
public class SingleHungry {
	private SingleHungry(){}
	private static SingleHungry instance = new SingleHungry();
	public static SingleHungry getInstance(){
		return instance;
	}
}

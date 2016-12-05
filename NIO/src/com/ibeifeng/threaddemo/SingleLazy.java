package com.ibeifeng.threaddemo;

/**
 * 懒汉式
 * @author 金珠文
 * 2016年12月5日
 */
public class SingleLazy {
	//构造器私有化
	private SingleLazy(){}
	private static SingleLazy instance = null;
	public static SingleLazy getInstance(){
		//1 2
		if (instance == null) {
			synchronized (SingleLazy.class) {
				if (instance == null) {
					instance = new SingleLazy();
				}
			}
		}
		return instance;
	}
}

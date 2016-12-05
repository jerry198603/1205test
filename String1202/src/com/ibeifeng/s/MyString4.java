package com.ibeifeng.s;

import java.util.ArrayList;

public class MyString4 {

	public static void main(String[] args) {
		// System.out.println(getData());
		String data = getData();
		long begin = System.currentTimeMillis();
		String[] mysplit = mySplit(data);
//		System.out.println(data);
		for (String str : mysplit) {
			System.out.println(str + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println("自定义的方法：" + (end - begin));

//		long start1 = System.currentTimeMillis();
//		String[] split = data.split(",");
//		long end1 = System.currentTimeMillis();
//		System.out.println("系统自带的方法：" + (end1 - start1));
	}

	public static String getData() {
		final int COUNT = 10000;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= COUNT; i++) {
			if (i < COUNT) {
				sb.append(i + ",");
			} else {
				sb.append(i);
			}
		}
		return sb.toString();
	}

	public static String[] mySplit(String str) {
		ArrayList<String> arrayList = new ArrayList<String>();
		int len = -1;
		while ((len = str.indexOf(",")) != -1) {
			arrayList.add(str.substring(0, len));
			str = str.substring(len + 1);
		}
		arrayList.add(str);
		String[] strs = new String[arrayList.size()];
		return arrayList.toArray(strs);
	}

}

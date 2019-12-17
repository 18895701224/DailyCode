package com.szxy.code;

import org.junit.Test;

public class DailyCode {
	// 判断较长字符串里子字符串出现的次数，使用indexof;
	@Test
	public void test1() {
		String str = "sadasdewf8fsd76fds7daf7g6ahh84hf9aaddsdsdsd1";
		String s = "sd";
		int count = 0;
		int beginIndex = 0;
		while (true) {
			int s1 = str.indexOf(s, beginIndex);
			if (s1 != -1) {
				count++;
				beginIndex = s1 + 1;
			} else {
				break;
			}

		}
		System.out.println(count);
	}
	
	// 判断长字符串里子字符串出现的次数，不使用indexof;
	@Test
	public void test2() {
		String str1 = "sadasdewf8fsd76fds7daf7g6ahh84hf9aaddsdsdsd1";
		String str2 = "sd";
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int count = 0;
		int idx = 0;
		for (int i = 0; i < chs1.length; i++) {
			if (chs1[i] == chs2[idx]) {
				idx++;
				if (idx == chs2.length) {
					count++;
					idx = 0;
				}
			} else {
				idx = 0;
			}
		}
		System.out.println(count);
	}
	//冒泡排序
	@Test
	public void test3(){
		double[] arr = new double[10];
		for (int i = 0; i <arr.length ; i++) {
			arr[i] = Math.random()*100;
		}
		for (int i = 0; i <arr.length-1 ; i++) {
			for (int j = 0; j <arr.length-1-i ; j++) {
				if(arr[j]<arr[j+1]){
					double tem = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tem;
				}
			}
		}
		for (double v : arr) {
			System.out.println(v);
		}
	}
	//选择排序
	@Test
	public void selectOrder(){
		double[] arr = new double[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.random()*100;

		}
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			for (int j = i+1; j <arr.length; j++) {
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				double tem = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tem;

			}

		}
		for (double v : arr) {
			System.out.println(v);
		}

	}
}

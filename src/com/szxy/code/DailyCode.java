package com.szxy.code;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import org.junit.Test;

import javax.swing.*;
import java.util.Random;

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
	@Test
	public  void yangHui(){
		int[][]  ssr = new int[10][];
		for (int i = 0; i < ssr.length; i++) {
			ssr[i]  = new int[i+1];
			ssr[i][0] = ssr[i][i] =1;
			if(i>=2){
				for (int j = 1; j < ssr[i].length-1; j++) {
					ssr[i][j] =ssr[i-1][j-1] + ssr[i-1][j];

				}
			}
		}
		for (int i = 0;i<ssr.length;++i){
			for (int j = 0;j<ssr[i].length;++j){
				System.out.print(ssr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	@Test
	public void test11(){
		Singleton1 s1 = Singleton1.getSinle1();
		Singleton1 s2 = Singleton1.getSinle1();
		System.out.println(s1 == s2);
		Singleton2 s3 = Singleton2.getSingle2();
		Singleton2 s4 = Singleton2.getSingle2();
		System.out.println(s3 == s4);

	}


	//快速排序
	public static void quickSort(int[] arr,int left,int right){
		//判断 如果左边索引比右边索引大 直接结束
		if(left > right){
			return ;
		}
		//定义变量保存基准数   首先从右向左检索，比基准数小则停下，然后left从左向右走
		int base = arr[left];
		//定义变量i，指向最左边
		int i = left;
		//定义变量j,指向最右边
		int j = right;
		//当i 和 j不相遇的时候，在循环中进行检索
		while(i != j){
			//首先从右向左检索，比基准数小则停下,相反 如果检索到比基准数大或相等，则继续检索
			while(arr[j] >= base && i < j){
				j--;//j从右往左移动
			}
			while (arr[i] <= base && i < j ){
				i++;//从左往右移动
			}
			//代码走到这里 i 停下 j 也停下 交换i 和 j位置元素的值
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		//如果跳出了上面的循环则说明 i = j ，则将两值进行交换
		//把相遇位置的元素赋值给基准数，
		arr[left] = arr[i];
		//把基准数的值赋给arr[i]
		arr[i] = base;
		//基准数已归位，左边全比基准数小，右边比基准数大
		//排基准数左边
		quickSort(arr,left,i-1);
		//排基准数右边
		quickSort(arr,j+1,right);
	}


}
//设计模式是在大量的实践中总结和理论化之后优选的代码结构，编程风格以及解决问题的思考方式
//饿汉式单例模式
class Singleton1{
	//私有化构造器
	private Singleton1(){
	}
	//静态方法只能访问类中的静态成员变量
	private static Singleton1 singel1 = new Singleton1();
	//声明成公共方法，方便外部调用
	public static Singleton1 getSinle1(){
		return singel1;
	}
}
//懒汉式单例模式
class Singleton2{
	//私有化构造器
	private Singleton2(){

	}

	private static  Singleton2 single2 = null;

	public static  Singleton2 getSingle2(){
		if(single2 == null){
			single2 = new Singleton2();
		}
		return single2;
	}
}
//线程安全的懒汉式单例设计模式
class Singleton{
	private String str;
	private static volatile Singleton singleton;//第二层锁，volatile关键字禁止指令重排
	private Singleton(){
		str="hello";
	}
	public String getStr() {
		return str;
	}
	public static Singleton getInstance(){
		if(singleton==null){//第一层检查，检查是否有引用指向对象，高并发情况下会有多个线程同时进入
			synchronized (Singleton.class){//第一层锁，保证只有一个线程进入
				//双重检查，防止多个线程同时进入第一层检查(因单例模式只允许存在一个对象，故在创建对象之前无引用指向对象，所有线程均可进入第一层检查)
				//当某一线程获得锁创建一个Singleton对象时,即已有引用指向对象，singleton不为空，从而保证只会创建一个对象
				//假设没有第二层检查，那么第一个线程创建完对象释放锁后，后面进入对象也会创建对象，会产生多个对象
				if(singleton==null){//第二层检查
					//volatile关键字作用为禁止指令重排，保证返回Singleton对象一定在创建对象后
					singleton=new Singleton();
					//singleton=new Singleton语句为非原子性，实际上会执行以下内容：
					//(1)在堆上开辟空间；(2)属性初始化;(3)引用指向对象
					//假设以上三个内容为三条单独指令，因指令重排可能会导致执行顺序为1->3->2(正常为1->2->3),当单例模式中存在普通变量需要在构造方法中进行初始化操作时，单线程情况下，顺序重排没有影响；但在多线程情况下，假如线程1执行singleton=new Singleton()语句时先1再3，由于系统调度线程2的原因没来得及执行步骤2，但此时已有引用指向对象也就是singleton!=null，故线程2在第一次检查时不满足条件直接返回singleton，此时singleton为null(即str值为null)
					//volatile关键字可保证singleton=new Singleton()语句执行顺序为123，因其为非原子性依旧可能存在系统调度问题(即执行步骤时被打断)，但能确保的是只要singleton!=0，就表明一定执行了属性初始化操作；而若在步骤3之前被打断，此时singleton依旧为null，其他线程可进入第一层检查向下执行创建对象
				}
			}
		}
		return singleton;
	}
}

class ThreadTest{
	public static void main(String[] args) {
		Singleton singleton=Singleton.getInstance();
		System.out.println(singleton);
	}
}

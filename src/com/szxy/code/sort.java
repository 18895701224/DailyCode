package com.szxy.code;

import org.junit.Test;

import java.util.Random;

/**
 * @author YKC
 * @create 2019-12-26 18:19
 */
public class sort {

    @Test//测试大量数据所用时间
    public void sorts(){
        //定义一个数组
        int[] arr = new int[1000];
        Random r = new Random();
        //给数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            //生成随机数
            arr[i] = r.nextInt();//如果不传递参数，随机数的范围是int范围
        }
        //排序之前记录时间
        long start = System.currentTimeMillis();//获取到当前系统值的时间，以ms值表示的
        //排序的方法
        //quickSort(arr,0,arr.length-1);
          //mpSort(arr);
          selectSort(arr);
        //排序之后的时间
        long end = System.currentTimeMillis();
        //耗费时间
        System.out.println(end - start);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test//测试快速排序
    public void sort(){

        int[] arr = {3,4,5,7,6,2,1,9,8,23,321,3213,43,3123};
        //selectSort(arr);
        quickSort(arr,0,arr.length-1);
      //  mpSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //选择排序
    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

    //冒泡排序
    public void mpSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }

        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
    }
    //快速排序
    public void quickSort(int[] arr,int left,int right){
        //先判断 left如果大于right 就return
        if(left > right ){
            return;
        }
        //定义基准值
        int base = arr[left];
        //定义变量i的值 从左向右检索，检索大于基准值得值
        int i = left;
        //定义变量j 的值，从右向左检索，检索小于基准值的值
        int j = right;
        //i和j分别检索的时候 i和j 需满足i ！= j 的情况 ，否则就会停止 用while循环
        while(i != j){
            //判断j循环的条件，当j索引的值小于基准值才会停下 反之 大于等于基准值则j会一直检索同时需要满足i < j;
            while(arr[j] >= base && i < j){
                j--;
            }
            //判断i循环的条件，当i索引的值大于基准值才会停下 反之 小于等于基准值i会一直检索 同时需要满足i<j;
            while(arr[i] <= base && i < j){
                i++;
            }
            //执行到这说明 i 和 j 都已经停了下来 则可交换i和j索引所对的值
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //执行到这说明i= j;则需要将基准值和 i互换
        //将i的值赋给基准值
        arr[left] = arr[i];
        //将基准值赋给i;
        arr[i] = base;
        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);

    }
}

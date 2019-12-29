package com.szxy.code;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

/**
 * @author YKC
 * @create 2019-12-19 17:59
 */
public class testMethod {
    public static void main(String[] args) {

        int[]  coins = new int[4];
        for (int i = 0; i < coins.length; i++) {
           coins[i] = (int)(Math.random()*100)+1;

        }
        for (int i = 0; i < coins.length; i++) {
            System.out.println(coins[i]);

        }
        int i = coinChange(coins, 6799);
        System.out.println(i);



    }


    public static int coinChange(int[] coins, int amount) {
        //初始化答案数组
        if( amount == 0 ){
            return 0;
        }
        int [] ans = new int[amount+1];
        for( int i = 0 ; i < coins.length ; ++i){
            if( coins[i] > amount ){
                continue;
            }
            ans[coins[i] ] = 1;
        }
        for( int i = 1 ; i <= amount ; ++i ){
            //已经初始化过
            if( ans[i] != 0 ){
                continue;
            }
            //mi用来保存临时最小值
            int mi = Integer.MAX_VALUE;
            for( int j = 0 ; j < coins.length ; ++j ){
                //上一次的面额不合法
                if( i - coins[j] <= 0 || ans[ i - coins[j] ] == 0 ){
                    continue;
                }
                mi = Math.min( mi , ans[i - coins[j]  ] + 1);
            }
            mi = mi == Integer.MAX_VALUE ? 0 : mi ;
            ans[i] = mi;
        }
        return ans[amount] == 0 ? -1 : ans[amount];

    }
    @Test
    public void sortTest(){
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(((Math.random()+1)-1)*1000000);
        }
        long start = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i : arr) {
            System.out.println(i);
        }



    }

    //快速排序
    public void quickSort(int[] arr,int left,int right) {
        //首先判断 left 不能大于 right (left,right 皆为下标)
        if(left > right){
           return;
        }
        //定义基准数
        int base = arr[left];
        int i = left;
        int j = right;
        //设置循环当 i != j的时候i和j在数组中循环一个从右向左找比base小的值，一个从左向右找比base大的值 找到就停下 两个都停下交换所得数据然后继续循环当left和right指向
        //同一个数的时候，就将这个数和基准数进行交换，然后原基准数左边进行递归循环，右边同样也是
        while(i != j){
            //判断j不停下来即j没找到比base小的数 即j>=base
            while(arr[j] >= base &&  i < j){
                j--;
            }

            //判断i不停下来即i没找到比base大的数 即i<= base
            while(arr[i] <= base && i < j){
                i++;
            }
            //当运行到这里说明i和j都停了下来 此时交换i 和 j所对应的值
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
        //运行到这里说明i = j ，需将base值和arr[i]的值进行交换
        arr[left] = arr[i];
        arr[i] = base;
        //再从base值左右两边重新进行递归排序 直到排完
        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);


    }


}

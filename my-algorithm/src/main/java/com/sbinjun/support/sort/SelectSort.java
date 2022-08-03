package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 原地，稳定
 */
public class SelectSort {

    private static int loop = 0;

    // a 表示数组，n 表示数组大小
    public static void sort(int[] a,int n){
        if ( n <= 1 ) return;

        for (int i = 0; i < n; i++) {
            int minindex = i;
            for (int j = i + 1;j < n;j++) {
                if (a[j] < a[minindex]) {
                    minindex = j;
                }
            }

            int tmp = a[i];
            a[i] = a[minindex];
            a[minindex] = tmp;
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{4, 5, 3, 3, 2, 1};

        SelectSort sort = new SelectSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }

}

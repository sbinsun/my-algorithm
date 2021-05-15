package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private static int loop = 0;

    // a 表示数组，n 表示数组大小
    public void sort(int[] a,int n){
        if (n <= 1) return;

        for (int i = 0; i < n -1; i ++) {
            boolean hasExchange = false;
            for (int j = 0; j < n - 1; j ++){
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    hasExchange = true;
                }
            }

            if (!hasExchange) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

        BubbleSort sort = new BubbleSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }

}

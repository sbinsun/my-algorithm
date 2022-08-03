package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 原地，稳定
 */
public class InsertSort {

    private static int loop = 0;

    // a 表示数组，n 表示数组大小
    public void sort(int[] a,int n){
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i -1;
            for (; j >=0; j --){
                if (a[j] > value) {
                    a[j + 1] = a[j];
                }else {
                    // 已排序区间最后一个都比 a[i] 小，说明 a[i] 是最大的，直接放最后面
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

        InsertSort sort = new InsertSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }

}

package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 非原地，稳定
 */
public class MergeSort {

    private static int loop = 0;

    // a 表示数组，n 表示数组大小
    public void sort(int[] a,int n){
        sub_sort(a, 0, n - 1);
    }

    private void sub_sort(int[] a, int p, int r) {
        if (p >= r) return;

        int q = p + (r - p) / 2;
        sub_sort(a,p,q);
        sub_sort(a,q+1,r);
        merge(a, p,q, r);
    }

    private void merge(int[] a, int p,int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = p,j = q +1,k = 0;

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        int start = i,end = q;
//        if (j <= r) {
        if(i > q){
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for (i = 0; i < tmp.length; i++ ) {
            a[p++] = tmp[i];
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};

        MergeSort sort = new MergeSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }

}

package com.sbinjun.support.gdbd;

import java.util.Arrays;

/**
 * 分治算法
 * 求出一组数据的逆序对个数呢
 */
public class Nixudu {

    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a, int n) {
        num = 0;
        mergeSortCounting(a, 0, n-1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;

        int q = p + ((r - p) >> 1);
        mergeSortCounting(a,p,q);
        mergeSortCounting(a, q + 1,r);
        merge(a,p,q,r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int i = p,k = 0;
        int j = q + 1;
        int[] tmp = new int[r - p + 1];
        while (i <= p && j <= r)
        if (a[i] > a[j]){
            tmp[k++] = a[j++];
            num+= (q - i + 1);
        }else{
            tmp[k++] = a[i++];
        }

        int start = i,end = q;
        if (i > q) {
            start = j;
            end = r;
        }

        while (start <= end){
            tmp[k++] = a[start++];
        }

        for (i = 0; i < tmp.length; i++) {
            a[p++] = tmp[i];
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};

        Nixudu nixudu = new Nixudu();
        System.out.println(nixudu.count(arr,6));
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }
}

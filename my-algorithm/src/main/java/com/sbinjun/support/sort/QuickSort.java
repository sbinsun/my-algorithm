package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    private static int loop = 0;

    // a 表示数组，n 表示数组大小
    public static void sort(int[] a,int n){
        sortSub(a, 0, n - 1);
    }

    private static void sortSub(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r);
        sortSub(a, p, q - 1);
        sortSub(a,q + 1 ,r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p, j = p;
        while (j <= (r -1)) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
            j++;
        }

        a[r] = a[i];
        a[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{4, 5, 6, 1, 3, 1};

        QuickSort sort = new QuickSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
//        System.out.println("次数：" + loop);
    }

}

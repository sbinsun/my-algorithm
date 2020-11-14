package com.sbinjun.support.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

        HeapSort sort = new HeapSort();
        sort.sort(arr,6);
        System.out.println(Arrays.toString(arr));
    }

    // a 表示数组，n 表示数组大小
    // 堆元素是从数组下标0开始
    public void sort(int[] a,int n){
        if (n <= 1) return;

        // 原地建堆
        buildHeap(a,n);

        // 排序
        int t = n - 1;
        while (t >= 0){
            swap(a, 0,  t);
            t--;
            heapify(a, 0, t);
        }
    }

    private void buildHeap(int[] a,int n) {
        // 从最后一个非叶子节点开始 往前堆化
        int i = (n / 2) - 1;
        for (int k= i; k >= 0 ; k--) {
            heapify(a,k,n);
        }
    }

    private void heapify(int[] a, int k,int n) {
        int maxPos = k;
        if ((2*k + 1) < n && a[k] < a[(2*k + 1)]) maxPos = 2*k + 1;
        if ((2*k + 2) < n && a[maxPos] < a[(2*k + 2)]) maxPos = 2*k + 2;
        if ( maxPos == k) return;
        swap(a, maxPos, k);
        heapify(a,maxPos,n);
    }

    private void swap(int[] a, int left, int k) {
        int tmp = a[left];
        a[left] = a[k];
        a[k] = tmp;
    }
}



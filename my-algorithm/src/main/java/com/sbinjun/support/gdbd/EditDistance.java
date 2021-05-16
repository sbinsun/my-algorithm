package com.sbinjun.support.gdbd;

// 编辑距离 如何量化两个字符串的相似度？

public class EditDistance {

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    // a 的长度
    private int n = 6;
    // b 的长度
    private int m = 6;

    private int minDist = Integer.MAX_VALUE;

    // 莱文斯坦距离
    // 回溯解
    private void lwstBT(int i,int j,int dist){
        if (i == n) {
            dist = dist + m - j;
            if (dist < minDist) minDist = dist;
            return ;
        }

        if (j == n) {
            dist = dist + n - i;
            if (dist < minDist) minDist = dist;
            return ;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1,j + 1,dist);
        }else {
            lwstBT(i + 1,j + 1,dist + 1);
            lwstBT(i + 1,j ,dist + 1);
            lwstBT(i,j + 1,dist + 1);
        }
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        editDistance.lwstBT(0, 0, 0);
        System.out.println(editDistance.minDist);

    }



}

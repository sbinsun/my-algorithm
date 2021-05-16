package com.sbinjun.support.gdbd;

public class MaxIncre {
    public static void main(String[] args) {
        MaxIncre maxIncre = new MaxIncre();

        int[] arr = new int[]{2, 9, 3, 6, 5, 1, 7};
        System.out.println(maxIncre.maxIncre(arr));
    }

    // 最长递增子序列
    private int maxIncre(int[] arr){
        if (arr.length < 2) return arr.length;

        int[] dp = new int[arr.length];
        dp[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}

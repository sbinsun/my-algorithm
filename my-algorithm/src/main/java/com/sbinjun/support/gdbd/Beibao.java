package com.sbinjun.support.gdbd;

/**
 * 回溯算法/动态规划
 * 0-1 背包
 */
public class Beibao {

    private int[] items = {2,2,4,6,3}; // 物品的重量
    private int[] value = {3,4,8,9,6}; // 物品的价值
    private int n = 5;   // n 表示物品个数
    private int w = 9; // w 背包可承受重量

    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // 回溯算法解
    public void backTracking(int i, int cw) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }
        backTracking(i+1, cw);
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候,就不要再装了
            backTracking(i+1,cw + items[i]);
        }
    }

    // 背包升级版,加上价值
    public void backTracking2(int i,int cw,int cv){
        if (cw >= w || i == n){
            if (cv > maxW) maxW = cv;
            return;
        }

        backTracking2(i + 1,cw,cv);
        if ((cw + items[i]) <= w){
            backTracking2(i + 1, cw + items[i],cv + value[i]);
        }
    }


/*********************************************************************************************************************/

    // 动态规划解
    public int dynamic(){
        boolean[][] states = new boolean[n][w + 1];
        // 初始化第0个物品的状态
        states[0][0] = true;            // 不放第0个物品
        states[0][items[0]] = true; // 放第0个物品
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i -1][j]) states[i][j] = true; // 不放第i个物品
            }

            for (int j = 0; j <= (w - items[i]); j++) {
                if (states[i -1][j]) {
                    states[i][j + items[i]] = true; // 放第i个物品
                }
            }
        }

        print(states);
        for (int i = w; i >= 0 ; i--) {
            if (states[n -1][i]) return i;
        }
        return 0;
    }

    // 背包升级版,加上价值
    public int dynamic2(){
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }

        // 初始化第0个物品的状态
        states[0][0] = 0;            // 不放第0个物品
        states[0][items[0]] = value[0]; // 放第0个物品
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i -1][j] >= 0) states[i][j] = states[i -1][j]; // 不放第i个物品
            }

            for (int j = 0; j <= (w - items[i]); j++) {
                if (states[i -1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+items[i]]) {
                        states[i][j+items[i]] = v;
                    }
                }
            }
        }

        print2(states);

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

    public int knapsack3() {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][items[0]] = value[0];
        for (int i = 1; i < n; ++i) { // 动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-items[i]; ++j) { // 选择第 i 个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+items[i]]) {
                        states[i][j+items[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

    private void print(boolean[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[row].length; column++) {
                if (result[row][column]) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void print2(int[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[row].length; column++) {
                System.out.print(result[row][column] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Beibao beibao = new Beibao();
        beibao.backTracking(0,0);
        System.out.println("maxV: " + beibao.maxW);

//        beibao.backTracking2(0,0,0);
//        System.out.println("maxV: " + beibao.maxW);

//        System.out.println(beibao.dynamic());
//        System.out.println(beibao.dynamic2());
//        System.out.println(beibao.knapsack3());
    }

}

package com.sbinjun.support.gdbd;

// 矩阵最短路径

/**
 * 4X4矩阵
 * 1 3 5 9
 * 2 1 3 4
 * 5 2 6 7
 *  6 8 4 3
 */
// 回溯解
// 动态规划解
public class MinMatrixPath {
    int minDist = Integer.MAX_VALUE;
    int[][] matrix;

    public static void main(String[] args) {
        MinMatrixPath minMatrixPath = new MinMatrixPath();
        minMatrixPath.matrix = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
//        minMatrixPath.setMinDistBt(0,0,1);
//        minMatrixPath.setMinDistDPTable();
//        System.out.println(minMatrixPath.minDist);

        System.out.println(minMatrixPath.setMinDistDPFun(4 - 1,4 - 1));
    }

    // 回溯解
    private void setMinDistBt(int i,int j,int dist) {
        if (i == 4 -1 && j == 4 -1 && dist < minDist) {
            minDist = dist;
        }

        if (i < 4 - 1) {
            setMinDistBt(i + 1, j, dist + matrix[i + 1][j]);
        }

        if (j < 4 - 1) {
            setMinDistBt(i , j + 1, dist + matrix[i][j + 1]);
        }
    }

    // 动态规划解
    // 状态转移表法
    private void setMinDistDPTable() {
        int[][] states = new int[4][4];
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            sum += matrix[0][k];
            states[0][k] = sum;
        }
        sum = 0;
        for (int k = 0; k < 4; k++) {
            sum += matrix[k][0];
            states[k][0] = sum;
        }

        for (int k = 1; k < 4; k++) {
            for (int l = 1; l < 4; l++) {
                states[k][l] = matrix[k][l] + Math.min(states[k - 1][l],states[k][l - 1]);
            }
        }
        minDist = states[3][3];
    }

    // 动态规划解
    // 状态转移方程法
    int[][] mem = new int[4][4];

    private int setMinDistDPFun(int i,int j) {
        if (i == 0 && j == 0) return matrix[0][0];
        if (mem[i][j] > 0) return mem[i][j];

        int up = Integer.MAX_VALUE;
        if (i > 0) {
            up = setMinDistDPFun(i - 1, j);
        }

        int left = Integer.MAX_VALUE;
        if (j > 0) {
            left = setMinDistDPFun(i, j - 1);
        }

        int dist = matrix[i][j] + Math.min(left, up);
        mem[i][j] = dist;
        return dist;
    }
}

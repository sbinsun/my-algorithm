package com.sbinjun.support.gdbd;

/**
 * 回溯算法
 * 八皇后
 * 有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线
 * 都不能有另一个棋子。八皇后问题就是期望找到所有满足这种要求的放棋子方式。
 */
public class EightQueen {

    private static int num = 0;
    private int[] result = new int[8];

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.cal8queens(0);
        System.out.println(num);
    }

    private void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            num++;
            return;
        }
        for (int column = 0; column < 8; ++column) {
            if (isOk(row,column)) {
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    private boolean isOk(int row, int col) {
        int leftUp = col - 1, rightUp = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == col) return false;
            else if (leftUp >= 0 && result[i] == leftUp) return false;
            else if (rightUp < 8 && result[i] == rightUp) return false;
            --leftUp; ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

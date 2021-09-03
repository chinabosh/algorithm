package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution20 {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * <p>
     * 一个数独的解法需遵循如下规则：
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     * <p>
     * Note:
     * <p>
     * 给定的数独序列只包含数字 1-9 和字符 '.' 。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     */

    public void solveSudoku(char[][] board) {
        solve(board);
        printSodu(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isSoduOk(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSoduOk(char[][] board, int i, int j, char tmp) {
        for (int k = 0; k < 9; k++) {
            if (k == i) {
                continue;
            }
            if (tmp == board[k][j]) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k == j) {
                continue;
            }
            if (tmp == board[i][k]) {
                return false;
            }
        }
        for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
            for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (tmp == board[k][l]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void printSodu(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

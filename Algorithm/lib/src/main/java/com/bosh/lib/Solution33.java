package com.bosh.lib;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lzq
 * @date 2022/1/28
 */
public class Solution33 {
    /**
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[["Q"]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        long start = System.nanoTime();
        solve(board, n, list);
        System.out.println((System.nanoTime() - start));
        return list;
    }

    private void solve(char[][] board, int n, List<List<String>> list) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'Q') {
                    board[i][j] = 'Q';
                    int solve = isSolve(board, n, list);
                    if (solve == 0) {
                        board[i][j] = '.';
                        count++;
                    } else if (solve == 1) {
                        board[i][j] = '.';
                        count++;
                    } else if (solve == 2) {
                        solve(board, n, list);
                        board[i][j] = '.';
                        count++;
                    }
                } else {
                    break;
                }
            }
            if (count == n) {
                return;
            }
        }
    }

    private int isSolve(char[][] board, int n, List<List<String>> list) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    for (int k = 0; k < n; k++) {
                        //横
                        if (k != j && board[i][k] == 'Q') {
                            return 0;
                        }//竖
                        if (k != i && board[k][j] == 'Q') {
                            return 0;
                        }
                        //斜
                        if (k != 0) {
                            if (i - k >= 0 && j - k >= 0 && board[i - k][j - k] == 'Q') {
                                return 0;
                            }
                            if (i + k < n && j - k >= 0 && board[i + k][j - k] == 'Q') {
                                return 0;
                            }
                            if (i + k < n && j + k < n && board[i + k][j + k] == 'Q') {
                                return 0;
                            }
                            if (i - k >= 0 && j + k < n && board[i - k][j + k] == 'Q') {
                                return 0;
                            }
                        }
                    }
                    count++;
                    break;
                }
            }
        }
        if (count == n) {
            addResult(board, n, list);
            return 1;
        }
        return 2;
    }

    private void addResult(char[][] board, int n, List<List<String>> list) {
        List<String> tmp = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            tmp.add(new String(board[k]));
        }
        list.add(tmp);
    }

    private int test(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 4) {
            return 2;
        } else if (n == 5) {
            return 10;
        } else if (n == 6) {
            return 4;
        } else if (n == 7) {
            return 40;
        } else if (n == 8) {
            return 92;
        } else if ( n == 9) {
            return 352;
        }
       return 0;
    }
}

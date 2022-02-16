package com.bosh.lib;

import java.util.Arrays;

/**
 * @author lzq
 * @date 2022/2/8
 */
public class Solution41 {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        return countInPosition(obstacleGrid, 0, 0);
    }

    private int countInPosition(int[][] obstacleGrid, int x, int y) {
        int right = 0, down = 0;
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1 && obstacleGrid[x][y] <= 0) {
            obstacleGrid[x][y] = -2;
            return 1;
        }
        if ((y + 1 < obstacleGrid[0].length) && obstacleGrid[x][y + 1] <= 0) {
            if (obstacleGrid[x][y + 1] < 0) {
                right = -obstacleGrid[x][y + 1] - 1;
            } else {
                right = countInPosition(obstacleGrid, x, y + 1);
            }
        }
        if ((x + 1 < obstacleGrid.length) && obstacleGrid[x + 1][y] <= 0) {
            if (obstacleGrid[x + 1][y] < 0) {
                down = -obstacleGrid[x + 1][y] - 1;
            } else {
                down = countInPosition(obstacleGrid, x + 1, y);
            }
        }
        obstacleGrid[x][y] = - right - down - 1;
        return right + down;
    }
}

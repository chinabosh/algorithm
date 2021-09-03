package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution14 {
    /**
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     * <p>
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * <p>
     * 请你返回最终形体的表面积。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[[2]]
     * 输出：10
     * 示例 2：
     * <p>
     * 输入：[[1,2],[3,4]]
     * 输出：34
     * 示例 3：
     * <p>
     * 输入：[[1,0],[0,2]]
     * 输出：16
     * 示例 4：
     * <p>
     * 输入：[[1,1,1],[1,0,1],[1,1,1]]
     * 输出：32
     * 示例 5：
     * <p>
     * 输入：[[2,2,2],[2,1,2],[2,2,2]]
     * 输出：46
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int countCube = 0;
        int countRepeat = 0;
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                countCube += grid[i][j];
                if (grid[i][j] > 0) {
                    if (i + 1 < len && grid[i + 1][j] > 0) {
                        countRepeat += Math.min(grid[i][j], grid[i + 1][j]);
                    }
                    if (j + 1 < len && grid[i][j + 1] > 0) {
                        countRepeat += Math.min(grid[i][j], grid[i][j + 1]);
                    }
                    countRepeat += grid[i][j] - 1;
                }
            }
        }
        return countCube * 6 - countRepeat * 2;
    }
}

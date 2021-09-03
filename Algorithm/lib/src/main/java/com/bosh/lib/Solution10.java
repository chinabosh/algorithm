package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution10 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;
        left[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > max) {
                max = height[i - 1];
            }
            left[i] = max;
        }
        max = 0;
        right[height.length - 1] = max;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > max) {
                max = height[i + 1];
            }
            right[i] = max;
        }
        int count = 0;
        int min = 0;
        for (int i = 0; i < height.length; i++) {
            min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                count += Math.min(left[i], right[i]) - height[i];
            }
        }
        return count;
    }
}

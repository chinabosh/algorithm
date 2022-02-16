package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/2/8
 */
public class Solution42 {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     *
     * 你需要按照以下要求，给这些孩子分发糖果：
     *
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例 2：
     *
     * 输入：ratings = [1,2,2]
     * 输出：4
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     *  
     *
     * 提示：
     *
     * n == ratings.length
     * 1 <= n <= 2 * 104
     * 0 <= ratings[i] <= 2 * 104
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/candy
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int candy(int[] ratings) {
        int[] counts = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if ((i - 1 < 0 || counts[i] <= counts[i - 1]) && (i + 1 >= ratings.length || counts[i] <= counts[i+1])) {
                counts[i] = 1;
            }
        }
        int index;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 1) {
                continue;
            }
            index = i;
            do {
                if (index - 1 < 0) {
                    break;
                }
                if (ratings[index - 1] <= ratings[index]) {
                    break;
                }
                if (counts[index - 1] > counts[index] + 1) {
                    break;
                }
                counts[index - 1] = counts[index] + 1;
                index--;
            } while (true);
            index = i;
            do {
                if (index + 1 >= counts.length) {
                    break;
                }
                if (ratings[index] >= ratings[index + 1]) {
                    break;
                }
                counts[index + 1] = counts[index] + 1;
                index++;
            } while (true);
        }
        int count = 0;
        for (int tmp : counts) {
            count += tmp;
        }
        return count;
    }
}

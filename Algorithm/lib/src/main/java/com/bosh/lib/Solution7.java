package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution7 {
    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * <p>
     * 不占用额外内存空间能否做到？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 给定 matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * 示例 2:
     * <p>
     * 给定 matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int tmp;
        int count = 0;
        for (int i = 0; i < length / 2; i++) {
            for (int j = count; j < length - count - 1; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - 1 - i][length - j - 1];
                matrix[length - 1 - i][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
            count++;
        }
    }

    /**
     * 每个点的旋转规则都是一样的
     */
}

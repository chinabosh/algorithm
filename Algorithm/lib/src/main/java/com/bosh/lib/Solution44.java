package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/2/10
 */
public class Solution44 {
    /**
     * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 13
     * 输出：6
     * 示例 2：
     *
     * 输入：n = 0
     * 输出：0
     *  
     *
     * 提示：
     *
     * 0 <= n <= 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-digit-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countDigitOne(int n) {
        int count = 0;
        int tmp;
        for (int i = 0; i <=n; i++) {
            tmp = i;
            while (tmp>0) {
                if (tmp % 10 == 1) {
                    count++;
                }
                tmp = tmp/10;
            }
        }
        return count;
    }
}

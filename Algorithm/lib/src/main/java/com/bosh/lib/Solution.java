package com.bosh.lib;

class Solution {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     *  
     *
     * 提示：
     *
     * -231 <= x <= 231 - 1
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int tmp = x % 10;
            x = (x - tmp) / 10;
            if (res > max || res < min) {
                return 0;
            }
            res = res * 10 + tmp;
        }
        return res;
    }
    /**
     * 反转常规操作不断取余，本题需要多考虑一个越界的问题
     * 2^31-1=2147483647
     * 若反转数y<2147483647,则y/10<214748364，反之亦然
     * 因x<2147483647,则x首位必<=2,所以y末位<=2<7,顾只需判断y/10<214748364
     * x为负数同理，所以当y>214748364或y<-214748364越界
     */
}
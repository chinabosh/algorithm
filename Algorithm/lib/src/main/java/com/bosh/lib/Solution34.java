package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/1/28
 */
public class Solution34 {
    /**
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * <p>
     * "123" 0
     * "132" 1
     * "213" 2
     * "231" 3
     * "312" 4
     * "321" 5
     * 给定 n 和 k，返回第 k 个排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3, k = 3
     * 输出："213"
     * 示例 2：
     * <p>
     * 输入：n = 4, k = 9
     * 输出："2314"
     * 示例 3：
     * <p>
     * 输入：n = 3, k = 1
     * 输出："123"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 9
     * 1 <= k <= n!
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int[] index = new int[n];
        int position, j;
        for (int i = 0; i < n; i++) {
            count *= i + 1;
        }
        k--;
        for (int i = 0; i < n; i++) {
            position = k / (count / (n - i));
            k = k % (count / (n - i));
            count = count / (n - i);
            j = 0;
            do {
                if (position == 0) {
                    if (index[j] == 0) {
                        sb.append(j + 1);
                        index[j] = 1;
                        break;
                    } else {
                        j++;
                    }
                }else {
                    if (index[j] == 0) {
                        j++;
                        position--;
                    } else {
                        j++;
                    }
                }
            } while (true);
        }
        return sb.toString();
    }
}

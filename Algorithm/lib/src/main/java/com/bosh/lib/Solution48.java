package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/2/10
 */
public class Solution48 {
    /**
     * 实现 strStr() 函数。
     *
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     *
     *  
     *
     * 说明：
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     * 示例 2：
     *
     * 输入：haystack = "aaaaa", needle = "bba"
     * 输出：-1
     * 示例 3：
     *
     * 输入：haystack = "", needle = ""
     * 输出：0
     *  
     *
     * 提示：
     *
     * 0 <= haystack.length, needle.length <= 5 * 104
     * haystack 和 needle 仅由小写英文字符组成
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(haystack) && "".equals(needle)) {
            return 0;
        } else if ("".equals(haystack) || "".equals(needle)){
            return -1;
        }
        int[][] dp = new int[needle.length()][26];
        dp[0][needle.charAt(0) - 'a'] = 1;
        int x = 0;
        for (int j = 1; j < dp.length;j++) {
            for (int k = 0; k < 26; k++) {
                if (needle.charAt(j) == ('a' + k)) {
                    dp[j][k] = j+ 1;
                } else {
                    dp[j][k] = dp[x][k];
                }
            }
            x = dp[x][needle.charAt(j) - 'a'];
        }
        int j = 0;
        for (int i = 0; i < haystack.length();i++) {
            j = dp[j][haystack.charAt(i) - 'a'];
            if (j == needle.length()) {
                return i - j  + 1;
            }
        }
        return -1;
    }
}

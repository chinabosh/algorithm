package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution21 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        String res = s.substring(0, 1);
        int a, b;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            a = i;
            b = i;
            while (true) {
                a++;
                b--;
                if (a >= len || b < 0) {
                    break;
                }
                if (s.charAt(a) == s.charAt(b)) {
                    if (a - b + 1 > res.length()) {
                        res = s.substring(b, a + 1);
                    }
                } else {
                    break;
                }
            }
            a = i + 1;
            b = i;
            if (a >= len || s.charAt(a) != s.charAt(b)) {
                continue;
            }
            if (2 > res.length()) {
                res = s.substring(b, a + 1);
            }
            while (true) {
                a++;
                b--;
                if (a >= len || b < 0) {
                    break;
                }
                if (s.charAt(a) == s.charAt(b)) {
                    if (a - b + 1 > res.length()) {
                        res = s.substring(b, a + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}

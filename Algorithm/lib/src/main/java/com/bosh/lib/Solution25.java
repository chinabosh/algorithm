package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution25 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s
     * @return 遇到重复的start跳到重复字符后面位置
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        do {
            int index = s.substring(start, end).indexOf(s.substring(end, end + 1));
            if (index != -1) {
                start += index + 1;
            } else {
                if (max < end - start + 1) {
                    max = end - start + 1;
                }
            }
            end++;
        } while (end < length);
        return max;
    }
}

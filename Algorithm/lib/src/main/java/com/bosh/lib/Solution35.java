package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/1/29
 */
public class Solution35 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     *  
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *  
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     *  
     *
     * 提示：
     *
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     *  
     *
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] index = new int[256];
        for (int i = 0; i < t.length(); i++) {
            index[t.charAt(i)]++;
        }
        int start = 0, end = 0;
        int startRes = -1, endRes= -1;
        int status = 0;
        while (true) {
            if (status == 0) {
                if (end >= s.length()) {
                    break;
                }
                index[s.charAt(end)] --;
                end++;
                if (hasContain(index)) {
                    status = 1;
                    if (startRes != -1) {
                        if (endRes - startRes > end - start) {
                            startRes = start;
                            endRes = end;
                        }
                    } else {
                        startRes = start;
                        endRes = end;
                    }
                    index[s.charAt(start)]++;
                    start++;
                }
            } else {
                if (hasContain(index)) {
                    index[s.charAt(start)]++;
                    start++;
                } else {
                    status = 0;
                    startRes = start -1;
                    endRes = end;
                }
            }
        }
        if (startRes >= 0 && endRes >=0) {
            return s.substring(startRes, endRes);
        }
        return "";
    }

    private boolean hasContain(int[] data) {
        boolean res = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution29 {
    /**
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        char[] tmp = new char[S.length()];
        int index = S.length() - 1;
        for (int i = 0, len = S.length(); i < len; i++) {
            char charTmp = S.charAt(i);
            if (!Character.isLetter(charTmp)) {
                tmp[i] = charTmp;
                continue;
            }
            for (int j = index; j >= i; j--) {
                if (!Character.isLetter(S.charAt(j))) {
                    tmp[j] = S.charAt(j);
                    continue;
                }
                System.out.println("i:" + S.charAt(i) + ", j:" + S.charAt(j));
                tmp[i] = S.charAt(j);
                tmp[j] = S.charAt(i);
                index = j - 1;
                break;
            }
            if (i >= index) {
                break;
            }
        }
        return String.valueOf(tmp);
    }
}

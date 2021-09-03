package com.bosh.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution19 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        List<Character> list = new ArrayList<>();
        int size;
        char tmp;
        for (int i = 0; i < len; i++) {
            tmp = s.charAt(i);
            if (isLeft(tmp)) {
                list.add(tmp);
            } else {
                size = list.size();
                if (size == 0) {
                    return false;
                }
                if (list.get(size - 1) == getLeft(tmp)) {
                    list.remove(size - 1);
                } else {
                    return false;
                }
            }
        }
        if (list.size() != 0) {
            return false;
        }
        return true;
    }

    private char getLeft(char value) {
        if (value == ')') return '(';
        if (value == '}') return '{';
        if (value == ']') return '[';
        return ' ';
    }

    private boolean isLeft(char value) {
        return value == '(' || value == '{' || value == '[';
    }
}

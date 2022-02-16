package com.bosh.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzq
 * @date 2022/2/7
 */
public class Solution38 {
    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     *
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     * 示例 4：
     *
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     * 示例 5：
     *
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 20
     * s 仅由数字组成
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) {
            return res;
        }
        int fir=1,sec=2,thi=3;
        do {
            if (isLegal(s.substring(0, fir))
                    && isLegal(s.substring(fir, sec))
                    && isLegal(s.substring(sec, thi))
                    && isLegal(s.substring(thi))) {
                String sb = s.substring(0, fir) +
                        "." +
                        s.substring(fir, sec) +
                        "." +
                        s.substring(sec, thi) +
                        "." +
                        s.substring(thi);
                res.add(sb);
            }
            if (thi < s.length() - 1) {
                thi++;
            } else {
                if (sec < s.length() - 2) {
                    sec++;
                    thi = sec + 1;
                } else {
                    if (fir < s.length() - 3) {
                        fir++;
                        sec = fir + 1;
                        thi = sec + 1;
                    } else {
                        break;
                    }
                }
            }
        } while (true);
        return res;
    }

    private boolean isLegal(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.length() >= 4) {
            return false;
        }
        if (s.charAt(0) == '0') {
            return false;
        }

        int tmp = Integer.parseInt(s);
        if (tmp <= 255) {
            return true;
        }
        return false;
    }
}

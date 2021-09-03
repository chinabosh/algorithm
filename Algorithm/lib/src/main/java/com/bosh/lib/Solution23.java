package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution23 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 例：
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        int length = s.length();
        int mov, index;
        boolean one;
        for (int i = 0; i < numRows; i++) {
            index = i;
            one = false;
            while (index < length) {
                ans.append(s.charAt(index));
                if (one) {
                    mov = i * 2;
                } else {
                    mov = (numRows - 1 - i) * 2;
                }
                one = !one;
                if (mov == 0) {
                    mov = (numRows - 1) * 2;
                }
                if (mov == 0) {
                    mov = 1;
                }
                index += mov;
            }
        }
        return ans.toString();
    }
}

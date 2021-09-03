package com.bosh.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution12 {
    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * 示例 2：
     * <p>
     * 输入：[1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * 示例 3：
     * <p>
     * 输入：[1]
     * 输出：false
     * 解释：没有满足要求的分组。
     * 示例 4：
     * <p>
     * 输入：[1,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]
     * 示例 5：
     * <p>
     * 输入：[1,1,2,2,2,2]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
     * <p>
     * 提示：
     * <p>
     * 1 <= deck.length <= 10000
     * 0 <= deck[i] < 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasGroupsSizeX(int[] deck) {
        boolean res = false;
        if (deck.length < 2) {
            return false;
        }
        Arrays.sort(deck);
        List<Integer> xList = new ArrayList<>();
        for (int i = 2; i <= deck.length; i++) {
            if (deck.length % i == 0) {
                xList.add(i);
            }
        }
        xList.add(deck.length);
        for (int i = 0; i < xList.size(); i++) {
            int size = xList.get(i);
            res = true;
            for (int j = 0; j < deck.length; j += size) {
                int tmp = deck[j];
                for (int k = 1; k < size; k++) {
                    if (tmp != deck[j + k]) {
                        res = false;
                        break;
                    }
                }
                if (!res) {
                    break;
                }
            }
            if (res) {
                break;
            }
        }
        return res;
    }
}

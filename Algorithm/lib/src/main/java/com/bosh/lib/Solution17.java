package com.bosh.lib;

import java.util.Arrays;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution17 {
    /**
     * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
     * <p>
     * 返回使 A 中的每个值都是唯一的最少操作次数。
     * <p>
     * 示例 1:
     * <p>
     * 输入：[1,2,2]
     * 输出：1
     * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
     * 示例 2:
     * <p>
     * 输入：[3,2,1,2,1,7]
     * 输出：6
     * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
     * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
     * 提示：
     * <p>
     * 0 <= A.length <= 40000
     * 0 <= A[i] < 40000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        int index = -1;
        int j = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                continue;
            }
            if (index < A[i]) {
                index = A[i];
                j = i;
            }
            index++;
            while (true) {
                if (j == A.length) {
                    break;
                }
                if (index > A[j]) {
                    j++;
                } else if (index == A[j]) {
                    index++;
                } else {
                    if (A[j] - A[j - 1] == 1) {
                        index += 2;
                        j++;
                    } else {
                        break;
                    }
                }
            }
            count += index - A[i];
        }
        return count;
    }
}

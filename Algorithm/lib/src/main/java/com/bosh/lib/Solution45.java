package com.bosh.lib;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lzq
 * @date 2022/2/10
 */
public class Solution45 {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = deque.peekFirst();
            }
        }

        return res;
    }
}

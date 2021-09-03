package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution4 {
    /**
     * 给你一个整数数组 nums 和一个整数 k。
     * <p>
     * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * <p>
     * 请返回这个数组中「优美子数组」的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * 示例 3：
     * <p>
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] oddIndex = new int[nums.length + 3];
        int num = 0;
        int index = 0;
        oddIndex[index++] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                oddIndex[index++] = i;
            }
        }
        if (index < k + 1) {
            return 0;
        }
        oddIndex[index++] = nums.length;
        oddIndex[index] = -1;
        index = 1;
        while (oddIndex[index + k] >= 0) {
            num += (oddIndex[index] - oddIndex[index - 1]) * (oddIndex[index + k] - oddIndex[index + k - 1]);
            index++;
        }
        return num;
    }
}

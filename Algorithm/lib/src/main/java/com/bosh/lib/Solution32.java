package com.bosh.lib;

/**
 * @author lzq
 * @date 2022/1/28
 */
public class Solution32 {
    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     *
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int firstMissingPositive(int[] nums) {
        int flag = -232;
        int tmp;
        int index;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flag) {
                continue;
            }
            tmp = nums[i];
            do {
                if (tmp - 1 < 0 || tmp - 1 >= nums.length) {
                    break;
                }
                index = tmp - 1;
                tmp = nums[tmp - 1];
                nums[index] = flag;
            } while (tmp != flag);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != flag) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}

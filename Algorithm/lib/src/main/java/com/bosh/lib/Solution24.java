package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution24 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * @param nums1
     * @param nums2
     * @return 用index标记最大最小，每次首尾各移动一次，最后剩一个或两个即可求的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1, start2, end1, end2;
        double res = 0;
        if (nums1 != null) {
            if (nums1.length == 0) {
                start1 = 1;
                end1 = 0;
            } else if (nums1.length == 1) {
                start1 = 0;
                end1 = 0;
            } else {
                if (nums1[0] <= nums1[nums1.length - 1]) {
                    start1 = 0;
                    end1 = nums1.length - 1;
                } else {
                    start1 = nums1.length - 1;
                    end1 = 0;
                }
            }
        } else {
            start1 = 1;
            end1 = 0;
        }
        if (nums2 != null) {
            if (nums2.length == 0) {
                start2 = 1;
                end2 = 0;
            } else if (nums2.length == 1) {
                start2 = 0;
                end2 = 0;
            } else {
                if (nums2[0] <= nums2[nums2.length - 1]) {
                    start2 = 0;
                    end2 = nums2.length - 1;
                } else {
                    start2 = nums2.length - 1;
                    end2 = 0;
                }
            }
        } else {
            start2 = 1;
            end2 = 0;
        }
        do {
            if (start1 > end1 && start2 > end2) {
                break;
            }
            if (start1 > end1) {
                if (start2 - end2 == 0 || start2 - end2 == -1) {
                    res = (double) (nums2[start2] + nums2[end2]) / 2;
                    break;
                }
            } else if (start1 == end1) {
                if (start2 == end2) {
                    res = (double) (nums1[start1] + nums2[start2]) / 2;
                    break;
                } else if (start2 > end2) {
                    res = nums1[start1];
                    break;
                }
            } else {
                if (start1 + 1 == end1 && start2 > end2) {
                    res = (double) (nums1[start1] + nums1[end1]) / 2;
                    break;
                }
            }
            if (start1 <= end1 && start2 <= end2) {
                if (nums1[start1] < nums2[start2]) {
                    start1++;
                } else {
                    start2++;
                }
                if (nums1[end1] > nums2[end2]) {
                    end1--;
                } else {
                    end2--;
                }
            } else if (start1 > end1) {
                start2++;
                end2--;
            } else {
                start1++;
                end1--;
            }
        } while (true);
        return res;
    }
}

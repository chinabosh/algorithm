package com.bosh.lib;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author lzq
 * @date 2022/2/10
 */
public class Solution46 {
    /**
     * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：points = [[1,1],[2,2],[3,3]]
     * 输出：3
     * 示例 2：
     *
     *
     * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
     * 输出：4
     *  
     *
     * 提示：
     *
     * 1 <= points.length <= 300
     * points[i].length == 2
     * -104 <= xi, yi <= 104
     * points 中的所有点 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxPoints(int[][] points) {
        int max = 2;
        Hashtable<double[], Integer> hashSet = new Hashtable<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                double[] tmp = getLine(points[i], points[j]);
                if (hashSet.containsKey(tmp)) {
                    int count = hashSet.get(tmp) + 1;
                    if (count > max) {
                        max = count;
                    }
                    hashSet.put(tmp, count);
                } else {
                    hashSet.put(tmp, 2);
                }
            }
        }
        return 2;
    }

    private double[] getLine(int[] a, int[] b) {
        double[] res = new double[2];
        res[0] = (double) (b[1] - a[1]) / (double) (b[0] - a[0]);
        res[1] = (double) a[1] - res[0] * a[0];
        return res;
    }
}

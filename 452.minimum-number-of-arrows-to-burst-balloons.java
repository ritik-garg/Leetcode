/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

/*
50/50 cases passed (53 ms)
Your runtime beats 81.17 % of java submissions
Your memory usage beats 58.42 % of java submissions (68.9 MB)
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
            }
        });
        int count = 0, i = 0;
        while (i < points.length) {
            int end = points[i][1];
            while (i < points.length && points[i][0] <= end) {
                end = Math.min(points[i][1], end);
                i++;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

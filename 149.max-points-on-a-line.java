/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

/*
41/41 cases passed (20 ms)
Your runtime beats 79.07 % of java submissions
Your memory usage beats 64.41 % of java submissions (44.2 MB)
 */
 
// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int answer = 1, n = points.length;
        for (int i = 0; i < n; ++i) {
            Map<Double, Integer> count = new HashMap<>();
            for (int j = i + 1; j < n; ++j) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                Double dy_dx;
                if (dy == 0) dy_dx = 0.0;
                else if (dx == 0) dy_dx = 1000000000.0;
                else dy_dx = (1.0 * dy) / dx;
                count.put(dy_dx, count.getOrDefault(dy_dx, 0) + 1);
                answer = Math.max(answer, count.get(dy_dx) + 1);
            }
        }
        return answer;
    }
}
// @lc code=end


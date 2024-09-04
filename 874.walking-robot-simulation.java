/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

/*
49/49 cases passed (34 ms)
Your runtime beats 53.27 % of java submissions
Your memory usage beats 43.23 % of java submissions (49.9 MB)
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + ", " + obstacle[1]);
        }
        
        int x = 0, y = 0, d = 0;
        int maxDist = 0;
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int c : commands) {
            if (c == -2) {
                d = (d + 1) % 4;
            } else if (c == -1) {
                d = d == 0 ? 4 : d;
                d--;
            } else {
                for (int i = 1; i <= c; ++i) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];
                    if (obstacleSet.contains(nx + ", " + ny)) break;
                    x = nx;
                    y = ny;
                }
                maxDist = Math.max(maxDist, x * x + y * y);
            }
        }
        return maxDist;
    }
}
// @lc code=end


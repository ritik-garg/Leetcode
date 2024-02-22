/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

/*
92/92 cases passed (2 ms)
Your runtime beats 99.85 % of java submissions
Your memory usage beats 63.27 % of java submissions (53.6 MB)
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for (int i = 0; i < trust.length; ++i) {
            trustCount[trust[i][1]]++;
        }
        
        int mayor = 0;
        for(int i = 1; i <= n; ++i) {
            if (trustCount[i] == n - 1) {
                mayor = i;
            }
        }

        for (int i = 0; i < trust.length; ++i) {
            if (trust[i][0] == mayor) return -1;
        }
        return mayor == 0 ? -1 : mayor;
    }
}
// @lc code=end


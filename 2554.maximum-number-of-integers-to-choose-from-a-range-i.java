/*
 * @lc app=leetcode id=2554 lang=java
 *
 * [2554] Maximum Number of Integers to Choose From a Range I
 */

/*
208/208 cases passed (4 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 62.34 % of java submissions (45.7 MB)
 */

// @lc code=start
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] b = new boolean[10001];
        for(int i : banned) b[i] = true;
        int sum = 0, c = 0;
        for (int i = 1; i <= n && sum < maxSum; ++i) {
            if (!b[i]) {
                sum += i;
                if (sum <= maxSum) c++;
            }
        }
        return c;
    }
}
// @lc code=end


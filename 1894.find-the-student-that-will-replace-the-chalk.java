/*
 * @lc app=leetcode id=1894 lang=java
 *
 * [1894] Find the Student that Will Replace the Chalk
 */

/*
72/72 cases passed (1 ms)
Your runtime beats 99.36 % of java submissions
Your memory usage beats 60.59 % of java submissions (59.8 MB)
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += chalk[i];
            if (sum > k || sum <= 0) break;
        }
        if (sum <= k && sum > 0) {
            k = k % sum;
        }
        for(int i = 0; i < n; ++i) {
            k -= chalk[i];
            if (k < 0) return i;
        }
        return -1;
    }
}
// @lc code=end


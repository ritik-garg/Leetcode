/*
 * @lc app=leetcode id=1550 lang=java
 *
 * [1550] Three Consecutive Odds
 */

/*
38/38 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 55.09 % of java submissions (42.4 MB)
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; ++i) {
            if (arr[i] % 2 == 1) {
                if (arr[i + 1] % 2 == 1) {
                    if (arr[i + 2] % 2 == 1) {
                        return true;
                    } else i += 2;
                } else i++;
            } 
        }
        return false;
    }
}
// @lc code=end


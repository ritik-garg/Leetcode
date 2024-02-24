/*
 * @lc app=leetcode id=1406 lang=java
 *
 * [1406] Stone Game III
 */

/*
185/185 cases passed (8 ms)
Your runtime beats 90.54 % of java submissions
Your memory usage beats 94.14 % of java submissions (55.7 MB)
 */

// @lc code=start
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int a = 0, b = 0, c = 0;
        
        for(int i = stoneValue.length - 1; i >= 0; --i) {
            int result = stoneValue[i] - a;
            if (i+1 < n)
                result = Math.max(result, stoneValue[i] + stoneValue[i+1] - b);
            if (i + 2 < n)
                result = Math.max(result, stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - c);

            c = b;
            b = a;
            a = result;
        }

        if (a < 0) return "Bob";
        if (a > 0) return "Alice";
        return "Tie";
    }
}
// @lc code=end


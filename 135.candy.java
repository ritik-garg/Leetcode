/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

/*
48/48 cases passed (4 ms)
Your runtime beats 38.35 % of java submissions
Your memory usage beats 40.2 % of java submissions (45.6 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int total = candies[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            total += candies[i];
        }
        return total;
    }
}
// @lc code=end

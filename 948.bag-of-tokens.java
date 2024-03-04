/*
 * @lc app=leetcode id=948 lang=java
 *
 * [948] Bag of Tokens
 */

/*
147/147 cases passed (3 ms)
Your runtime beats 37.26 % of java submissions
Your memory usage beats 97.45 % of java submissions (42.3 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (power == 0 || tokens.length == 0) {
            return 0;
        }

        int maxScore = 0, currentScore = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            while (left <= right && tokens[left] <= power) {
                power -= tokens[left];
                left++;
                currentScore++;
            }
            maxScore = Math.max(maxScore, currentScore);
            if (currentScore != 0) {
                power += tokens[right--];
                currentScore--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=2028 lang=java
 *
 * [2028] Find Missing Observations
 */

/*
64/64 cases passed (16 ms)
Your runtime beats 7.87 % of java submissions
Your memory usage beats 38.36 % of java submissions (61.8 MB)
 */

// @lc code=start
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0, m = rolls.length;
        for (int i = 0; i < m; ++i) sum += rolls[i];

        int remainingSum = mean * (m + n) - sum;
        double average = (1.0 * remainingSum) / n;
        if (average > 6 || average < 1) return new int[0];

        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            int averageInt = (int) average;
            answer[i] = averageInt;
            int newRemainingSum = remainingSum - averageInt;
            double newAverage = (1.0 * newRemainingSum) / (n - i - 1);
            if (newAverage > 6) {
                i--;
                average += 1;
                continue;
            }
            remainingSum = newRemainingSum;
            average = newAverage;
        }
        return answer;
    }
}
// @lc code=end


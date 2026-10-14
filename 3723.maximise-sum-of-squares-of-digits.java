/*
 * @lc app=leetcode id=3723 lang=java
 *
 * [3723] Maximise Sum of Squares of Digits
 */

/**
 * 
 * 1000/1000 cases passed (106 ms)
 * Your runtime beats 53.66 % of java submissions
 * Your memory usage beats 93.90 % of java submissions (47.5 MB)
 */

// @lc code=start
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) return "";

        StringBuilder ans = new StringBuilder("");
        while (sum > 0) {
            int nd = nextDigit(sum);
            sum -= nd;
            num--;
            ans.append(nd);
        }
        while (num > 0) {
            ans.append(0);
            num--;
        }

        return ans.toString();
    }

    int nextDigit(int sum) {
        if (sum >= 9) return 9;
        else return sum;
    }
}
// @lc code=end
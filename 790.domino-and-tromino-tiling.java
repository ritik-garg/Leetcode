/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

/**
 * Watch video of CodeWithMlk for solution
 */

/*
39/39 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.4 % of java submissions (40.2 MB)
 */

// @lc code=start
class Solution {
    private static int[] answers = new int[1001];
    private static int filled = 0;
    private static int MODULO = 1000000007;

    public int numTilings(int n) {
        if (answers[n] != 0) {
            return answers[n];
        } else {
            fill(3);
        }

        fill(n);
        return answers[n];
    }

    private void fill(int n) {
        if (n <= 3) {
            answers[0] = 0;
            answers[1] = 1;
            answers[2] = 2;
            answers[3] = 5;
            filled = 3;
            return;
        }

        for (int i = filled + 1; i <= n; ++i) {
            answers[i] = ((2 * answers[i - 1]) % MODULO + answers[i - 3]) % MODULO;
        }
    }
}
// @lc code=end


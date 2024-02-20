/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

/*
66/66 cases passed (37 ms)
Your runtime beats 99.01 % of java submissions
Your memory usage beats 5.07 % of java submissions (66.3 MB)
 */

// @lc code=start
class Solution {
    final static int LIMIT = 5000001;
    static int[] primes = new int[LIMIT];

    private void countPrimes() {
        boolean[] nums = new boolean[LIMIT];
        int count = 0;
        for(int i = 2; i < LIMIT; ++i) {
            primes[i] = count;
            if (!nums[i]) {
                int j = 1;
                while (i * j < LIMIT) {
                    nums[i * j++] = true;
                }
                count++;
            }
        }
    }

    public int countPrimes(int n) {
        if (n > 2 && primes[n] == 0) {
            countPrimes();
        }
        return primes[n];
    }
}
// @lc code=end

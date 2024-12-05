/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

/*
126/126 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.15 % of java submissions (40.2 MB)
 */

// @lc code=start
class Solution {
    private static boolean[] primes = new boolean[1001];

    private void fillPrimes() {
        if (primes[2]) return;
        for (int i = 2; i < 1001; ++i) primes[i] = true;
        for (int i = 2; i < 1001; ++i) {
            if (primes[i]) {
                for (int j = 2 * i; j < 1001; j = j + i) primes[j] = false;
            }
        }
    }

    public int minSteps(int n) {
        fillPrimes();
        return minSteps(n, 2);
    }

    private int minSteps(int n, int p) {
        int ans = 0;
        while (n > 1 && n % p == 0) {
            ans += p;
            n /= p;
        }
        if (n <= 1) return ans;
        p++;
        while (p < 1001 && !primes[p]) p++;
        if (p < 1001) ans += minSteps(n, p);
        return ans;
    }
}
// @lc code=end


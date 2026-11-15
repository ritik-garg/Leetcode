/*
 * @lc app=leetcode id=1524 lang=java
 *
 * [1524] Number of Sub-arrays With Odd Sum
 */

/*
151/151 cases passed (9 ms)
Your runtime beats 28.57 % of java submissions
Your memory usage beats 94.09 % of java submissions (81.1 MB)
*/

// @lc code=start
class Solution {
    private static final int MODULO = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int even = 0, odd = 0, ans = 0;

        for (int i = 0; i < n; ++i) {
            if (arr[i] % 2 == 0) {
                even = i == 0 ? 1 : (even + 1) % MODULO;
            } else {
                int t = even;
                even = i == 0 ? 0 : odd;
                odd = i == 0 ? 1 : (t + 1) % MODULO;
            }
            ans = (ans + odd) % MODULO;
        }

        return ans;
    }
}
// @lc code=end


/**

151/151 cases passed (11 ms)
Your runtime beats 13.63 % of java submissions
Your memory usage beats 99.51 % of java submissions (80 MB)

class Solution {
    private static final int MODULO = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] even = new int[n], odd = new int[n];
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (arr[i] % 2 == 0) {
                even[i] = i == 0 ? 1 : (even[i - 1] + 1) % MODULO;
                odd[i] = i == 0 ? 0 : odd[i - 1];
            } else {
                even[i] = i == 0 ? 0 : odd[i - 1];
                odd[i] = i == 0 ? 1 : (even[i - 1] + 1) % MODULO;
            }
            ans = (ans + odd[i]) % MODULO;
        }

        return ans;
    }
}
*/
/*
 * @lc app=leetcode id=1945 lang=java
 *
 * [1945] Sum of Digits of String After Convert
 */

/*
216/216 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 93.49 % of java submissions (41.38 MB)
 */

// @lc code=start
class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            int num = (ch - 'a') + 1;
            sum += (num % 10) + (num / 10);
        }
        for (int i = 0; i < k - 1; ++i) {
            int temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }
            sum = temp;
        }
        return sum;
    }
}
// @lc code=end


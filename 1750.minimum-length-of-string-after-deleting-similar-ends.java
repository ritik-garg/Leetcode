/*
 * @lc app=leetcode id=1750 lang=java
 *
 * [1750] Minimum Length of String After Deleting Similar Ends
 */

/*
100/100 cases passed (4 ms)
Your runtime beats 80.63 % of java submissions
Your memory usage beats 40.95 % of java submissions (45.3 MB)
 */

// @lc code=start
class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] == chars[right]) {
                while (left + 1 < right && chars[left] == chars[left + 1]) {
                    left++;
                }
                while (left < right - 1 && chars[right] == chars[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else {
                break;
            }
        }
        return right - left + 1;
    }
}
// @lc code=end


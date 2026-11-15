/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

/*
492/492 cases passed (2 ms)
Your runtime beats 99.4 % of java submissions
Your memory usage beats 84.66 % of java submissions (43.8 MB)
*/

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = sc.length - 1;
        while (i <= j) {
            if (!isAlphaNumeric(sc[i])) i++;
            else if (!isAlphaNumeric(sc[j])) j--;
            else {
                if (!isEqual(sc[i], sc[j])) return false;
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || isNumber(c);
    }

    private boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean isEqual(char c1, char c2) {
        if ((isNumber(c1) && !isNumber(c2)) || (isNumber(c2) && !isNumber(c1))) return false; 
        int diff = Math.abs(c1 - c2);
        return diff == 0 || diff == 32;
    }
}
// @lc code=end


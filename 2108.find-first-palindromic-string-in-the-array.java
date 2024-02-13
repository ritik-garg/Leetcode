/*
 * @lc app=leetcode id=2108 lang=java
 *
 * [2108] Find First Palindromic String in the Array
 */

/*
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 51.22 % of java submissions (57.2 MB)
 */

// @lc code=start
class Solution {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int start = 0, end = word.length() - 1;
        while (start <= end) {
            if (word.charAt(start++) != word.charAt(end--))
                return false;
        }
        return true;
    }
}
// @lc code=end

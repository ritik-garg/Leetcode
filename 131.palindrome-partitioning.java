/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

/*
 * 32/32 cases passed (8 ms)
 * Your runtime beats 66.2 % of java submissions
 * Your memory usage beats 23.13 % of java submissions (57.2 MB)
 */
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        boolean[][] isPalindrome = new boolean[n][n];
        fillPalindromeArray(isPalindrome, s, n);
        findAllPartitions(s, isPalindrome, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void findAllPartitions(String s, boolean[][] isPalindrome, List<List<String>> ans, List<String> currList, int currIndex) {
        if(currIndex == s.length()) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for(int i = currIndex; i < s.length(); ++i) {
            if (isPalindrome[currIndex][i]) {
                currList.add(s.substring(currIndex, i + 1));
                findAllPartitions(s, isPalindrome, ans, currList, i + 1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    private void fillPalindromeArray(boolean[][] isPalindrome, String s, int n) {
        for(int l = 1; l <= n; ++l) {
            for(int i = 0; i < n - l + 1; ++i) {
                int j = i + l - 1;
                if (l == 1) isPalindrome[i][j] = true;
                else if (l == 2) isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                else isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]);
            }
        }
    }
}
// @lc code=end


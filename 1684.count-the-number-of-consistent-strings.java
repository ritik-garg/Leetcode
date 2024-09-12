/*
 * @lc app=leetcode id=1684 lang=java
 *
 * [1684] Count the Number of Consistent Strings
 */

/*
74/74 cases passed (6 ms)
Your runtime beats 88.76 % of java submissions
Your memory usage beats 75 % of java submissions (45.1 MB)
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            allow[ch - 'a'] = true;
        }

        int answer = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!allow[ch - 'a']) {
                    answer--;
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
// @lc code=end


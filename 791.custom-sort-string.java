/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

/*
41/41 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 56.17 % of java submissions (41.5 MB)
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while(freq[ch - 'a']-- > 0) {
                answer.append(ch);
            }
        }

        for (int i = 0; i < 26; ++i) {
            while(freq[i]-- > 0) {
                answer.append((char)(i + 'a'));
            }
        }
        return answer.toString();
    }
}
// @lc code=end

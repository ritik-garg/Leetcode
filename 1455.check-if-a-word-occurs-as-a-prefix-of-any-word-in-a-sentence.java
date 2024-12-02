/*
 * @lc app=leetcode id=1455 lang=java
 *
 * [1455] Check If a Word Occurs As a Prefix of Any Word in a Sentence
 */

/*
42/42 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 41.46 % of java submissions (41.4 MB)
 */

// @lc code=start
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] sen = sentence.toCharArray(), sw = searchWord.toCharArray();
        int i = 0, count = 0;
        while (i < sen.length) {
            if (sen[i] == ' ') {
                i++;
                continue;
            }
            count++;
            int j = 0;
            while (j < sw.length && i < sen.length && sen[i] == sw[j]) {
                i++; j++;
            }
            if (j == sw.length) return count;
            while (i < sen.length && sen[i] != ' ') i++;
        }
        return -1;
    }
}
// @lc code=end


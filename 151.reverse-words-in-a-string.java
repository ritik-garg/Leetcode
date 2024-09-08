/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

/*
61/61 cases passed (4 ms)
Your runtime beats 95.96 % of java submissions
Your memory usage beats 45.93 % of java submissions (43.4 MB)
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        List<String> wordList = words(s.toCharArray());
        StringBuilder answer = new StringBuilder();
        for (int i = wordList.size() - 1; i >= 0; --i) {
            answer.append(wordList.get(i));
            if (i != 0) answer.append(' ');
        }
        return answer.toString();
    }

    private List<String> words(char[] s) {
        List<String> wordList = new ArrayList<>();
        int i = 0;
        while (i < s.length) {
            if (s[i] != ' ') {
                StringBuilder word = new StringBuilder();
                while (i < s.length && s[i] != ' ') {
                    word.append(s[i++]);
                }
                wordList.add(word.toString());
            } 
            i++;
        }
        return wordList;
    }
}
// @lc code=end


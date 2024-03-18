/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */

/*
168/168 cases passed (56 ms)
Your runtime beats 29.07 % of java submissions
Your memory usage beats 19.33 % of java submissions (47.2 MB)
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] binaryWords = new int[n];
        for (int i = 0; i < n; ++i) {
            binaryWords[i] = binaryWord(words[i].toCharArray());
        }

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((binaryWords[i] & binaryWords[j]) == 0) {
                    answer = Math.max(answer, words[i].length() * words[j].length());
                }
            }
        }
        return answer;
    }

    private int binaryWord(char[] word) {
        int binaryWord = 0;
        for (char ch : word) {
            binaryWord |= 1<<(26 - ch + 'a');
        }
        System.out.println(binaryWord + "");
        return binaryWord;
    }
}
// @lc code=end

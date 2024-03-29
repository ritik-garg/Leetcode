/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

/*
29/29 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 71.33 % of java submissions (41.6 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ) {
            int j = i, currLength = 0;
            while (j < n && currLength <= maxWidth) {
                currLength += words[j].length();
                if (currLength == maxWidth) break;
                else if (currLength > maxWidth) {
                    currLength -= words[j].length();
                    currLength--;
                    j--;
                    break;
                } else {
                    j++;
                    currLength++;
                }
            }  
            if (j == n) {
                j--;
                currLength--;
            }

            StringBuilder currString = new StringBuilder();
            if (j == n - 1) {
                for (int k = i; k < j; ++k) {
                    currString.append(words[k]);
                    currString.append(' ');
                }
                currString.append(words[j]);
                while (currString.length() < maxWidth) {
                    currString.append(' ');
                }
            } else {
                int spaces = maxWidth - currLength + j - i, numOfWords = j - i + 1;
                int spaceAfterEachWord = numOfWords == 1 ? spaces : spaces / (numOfWords - 1);
                spaces = numOfWords == 1 ? 0 : spaces - spaceAfterEachWord * (numOfWords - 1);
                for (int k = i; k <= j; ++k) {
                    currString.append(words[k]);
                    if (currString.length() < maxWidth) {
                        currString.append(" ".repeat(spaceAfterEachWord));
                        if (spaces > 0) {
                            currString.append(' ');
                            spaces--;
                        }
                    }
                }
            }
            answer.add(currString.toString());
            i = j + 1;
        }
        return answer;
    }
}
// @lc code=end


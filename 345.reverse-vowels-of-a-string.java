/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

/*
480/480 cases passed (3 ms)
Your runtime beats 83.09 % of java submissions
Your memory usage beats 20.37 % of java submissions (45.5 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Integer> index = new ArrayList<>();
        for(int i = s.length() - 1; i >= 0; --i) {
            if (isVovel(s.charAt(i))) {
                sb.append(s.charAt(i));
                index.add(i);
            }
        }

        StringBuilder answer = new StringBuilder(s);
        for(int i = index.size() - 1, j = 0; i >= 0; --i) {
                answer.setCharAt(index.get(i), sb.charAt(j++));
        }
        return answer.toString();
    }

    private boolean isVovel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
// @lc code=end


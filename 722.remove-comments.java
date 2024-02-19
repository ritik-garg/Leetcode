/*
 * @lc app=leetcode id=722 lang=java
 *
 * [722] Remove Comments
 */

/*
55/55 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 88.44 % of java submissions (41.5 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        int n = source.length;
        boolean insideComment = false;
        List<String> answer = new ArrayList<>();
        StringBuilder statement = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for(int j = 0; j < source[i].length(); ++j) {
                if (!insideComment && source[i].charAt(j) == '/') {
                    if (j < source[i].length() - 1 && source[i].charAt(j + 1) == '/') break;
                    if (j < source[i].length() - 1 && source[i].charAt(j + 1) == '*') {
                        insideComment = true;
                        j++;
                        continue;
                    }
                } 
                if (insideComment && source[i].charAt(j) == '*') {
                    if (j < source[i].length() - 1 && source[i].charAt(j + 1) == '/') {
                        insideComment = false;
                        j++;
                    }
                    continue;
                }
                if (!insideComment) {
                    statement.append(source[i].charAt(j));
                }
            }
            if (!insideComment && statement.length() != 0) {
                answer.add(statement.toString());
                statement = new StringBuilder();
            }
        }
        return answer;
    }
}
// @lc code=end


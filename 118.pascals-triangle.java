/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

/*
30/30 cases passed (1 ms)
Your runtime beats 82.71 % of java submissions
Your memory usage beats 64.5 % of java submissions (41.8 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(1));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = answer.get(i - 1);
            for (int j = 0; j <= prevRow.size(); ++j) {
                if (j == 0) row.add(prevRow.get(0));
                else if (j == prevRow.size()) row.add(prevRow.get(prevRow.size() - 1));
                else row.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            answer.add(row);
        }
        return answer;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

/*
172/172 cases passed (11 ms)
Your runtime beats 13.64 % of java submissions
Your memory usage beats 95.61 % of java submissions (48.2 MB)
*/

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int a = -1, b = -1;
        for (int[] i : intervals) {
            if (a == -1) {
                a = i[0];
                b = i[1];
            } else {
                if (b >= i[0]) b = Math.max(b, i[1]);
                else {
                    ans.add(new int[] {a, b});
                    a = i[0];
                    b = i[1];
                }
            }
        }
        ans.add(new int[] {a, b});
        return ans.toArray(new int[0][]);
    }
}
// @lc code=end


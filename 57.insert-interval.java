/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

/*
 * 156/156 cases passed (1 ms)
 * Your runtime beats 99.02 % of java submissions
 * Your memory usage beats 11.2 % of java submissions (45.2 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1], n = intervals.length;
        boolean isAdded = false;

        int i = 0;
        if (n == 0 || intervals[0][0] > end) {
            int[] interval = {start, end};
            ans.add(interval);
            isAdded = true;
        }
        
        while (i < n && start > intervals[i][1]) {
            int[] interval = {intervals[i][0], intervals[i][1]};
            ans.add(interval);
            i++;
        }

        while (i < n && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        if (isAdded == false) {
            int[] interval = {start, end};
            ans.add(interval);
        }

        while (i < n) {
            int[] interval = {intervals[i][0], intervals[i][1]};
            ans.add(interval);
            i++;
        }

        return ans.toArray(new int[ans.size()-1][]);
    }
}
// @lc code=end


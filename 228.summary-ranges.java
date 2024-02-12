/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

/*
 * 32/32 cases passed (5 ms)
 * Your runtime beats 83.82 % of java submissions
 * Your memory usage beats 64.76 % of java submissions (41.6 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        int s = nums[0], e = nums[0];
        for(int i = 1; i < n; ++i) {
            if(nums[i] != nums[i-1] + 1) {
                String t = s == e ? s + "" : s + "->" + e;
                ans.add(t);
                s = nums[i];
            } 
            e = nums[i];
        }
        String t = s == e ? s + "" : s + "->" + e;
        ans.add(t);
        return ans;
    }
}
// @lc code=end



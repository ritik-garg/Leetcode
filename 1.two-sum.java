/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

/*
 * 63/63 cases passed (2 ms)
 * Your runtime beats 97.08 % of java submissions
 * Your memory usage beats 47.2 % of java submissions (44.8 MB)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                return new int[] { m.get(target - nums[i]), i };
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
}
// @lc code=end

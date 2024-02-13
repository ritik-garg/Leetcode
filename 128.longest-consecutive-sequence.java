/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

/*
 * 75/75 cases passed (27 ms)
 * Your runtime beats 71 % of java submissions
 * Your memory usage beats 67.36 % of java submissions (57.6 MB)
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                int temp = num - 1;
                while (set.contains(temp)) {
                    count++;
                    set.remove(temp--);
                }
                temp = num + 1;
                while (set.contains(temp)) {
                    count++;
                    set.remove(temp++);
                }
                set.remove(num);
                max = max >= count ? max : count;
            }
        }

        return max;
    }
}
// @lc code=end

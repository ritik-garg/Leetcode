/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

/*
146/146 cases passed (1 ms)
Your runtime beats 99.21 % of java submissions
Your memory usage beats 82.71 % of java submissions (42.1 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        bactrack(s.toCharArray(), 0, 4, "", answer);
        return answer;
    }

    private void bactrack(char[] s, int start, int dots, String current, List<String> answer) {
        if (start >= s.length) {
            if (dots == 0) {
                answer.add(current);
            }
            return;
        } else if (dots == 0) {
            return;
        }
        int[] nums = new int[3];
        nums[0] = s[start] - '0';
        nums[1] = start + 1 < s.length && nums[0] != 0 ? nums[0] * 10 + (s[start + 1] - '0') : -1;
        nums[2] = start + 2 < s.length && nums[1] != 0 ? nums[1] * 10 + (s[start + 2] - '0') : -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0 && nums[i] <= 255) {
                StringBuilder next = new StringBuilder(current).append(String.valueOf(nums[i]));
                if (dots != 1) {
                    next.append('.');
                }
                bactrack(s, start + i + 1, dots - 1, next.toString(), answer);
            }
        }
    }
}
// @lc code=end


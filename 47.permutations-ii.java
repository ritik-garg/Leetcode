/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

/*
33/33 cases passed (1 ms)
Your runtime beats 99.96 % of java submissions
Your memory usage beats 79.2 % of java submissions (44.6 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, answer);
        return answer;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> answer) {
        if (start == nums.length) {
            answer.add(toList(nums));
        } else {
            for (int i = start; i < nums.length; ++i) {
                if (i == start || canPermute(nums, start, i)) {
                    swap(nums, start, i);
                    backtrack(nums, start + 1, answer);
                    swap(nums, start, i);
                }
            }
        }
    }

    private boolean canPermute(int[] nums, int start, int current) {
        for (int i = start; i < current; ++i) {
            if (nums[i] == nums[current]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums) list.add(n);
        return list;
    }
}
// @lc code=end

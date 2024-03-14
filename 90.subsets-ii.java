/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

/*
20/20 cases passed (1 ms)
Your runtime beats 99.81 % of java submissions
Your memory usage beats 84.76 % of java submissions (43.1 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        backtrack(0, nums, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int curIdx, int[] nums, List<Integer> list, List<List<Integer>> answer) {
        if (curIdx >= nums.length) return;
        int curVal = nums[curIdx];
        list.add(curVal);
        backtrack(curIdx + 1, nums, list, answer);
        answer.add(new ArrayList<>(list));
        list.removeLast();
        while (curIdx + 1 < nums.length && nums[curIdx] == nums[curIdx + 1]) {
            curIdx++;
        }
        backtrack(curIdx + 1, nums, list, answer);
    }
}
// @lc code=end
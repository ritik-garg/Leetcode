/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

/*
176/176 cases passed (2 ms)
Your runtime beats 99.27 % of java submissions
Your memory usage beats 76.63 % of java submissions (43 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, candidates, 0, target, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int i, int[] candidates, int sum, int target, List<Integer> c, List<List<Integer>> answer) {
        if (i >= candidates.length) return;
        sum += candidates[i];
        c.add(candidates[i]);
        if (sum == target) {
            answer.add(new ArrayList<>(c));
            c.removeLast();
            return;
        }
        if (sum > target) {
            c.removeLast(); 
            return;
        }
        backtrack(i + 1, candidates, sum, target, c, answer);

        sum -= candidates[i];
        c.removeLast();
        i++;
        while (i < candidates.length) {
            if (candidates[i] == candidates[i - 1]) i++;
            else break;
        }
        backtrack(i, candidates, sum, target, c, answer);
    }
}
// @lc code=end


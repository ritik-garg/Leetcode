/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

/*
160/160 cases passed (2 ms)
Your runtime beats 83.07 % of java submissions
Your memory usage beats 71.27 % of java submissions (44.4 MB)
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(0, 0, candidates, target, new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int i, int sum, int[] candidates, int target, List<Integer> c, List<List<Integer>> answer) {
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
        backtrack(i, sum, candidates, target, c, answer);

        sum -= candidates[i];
        c.removeLast();
        backtrack(i + 1, sum, candidates, target, c, answer);
    }
}
// @lc code=end


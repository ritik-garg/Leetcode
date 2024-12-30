/*
 * @lc app=leetcode id=2593 lang=java
 *
 * [2593] Find Score of an Array After Marking All Elements
 */

/*
1044/1044 cases passed (111 ms)
Your runtime beats 58.77 % of java submissions
Your memory usage beats 61.45 % of java submissions (59.2 MB)
 */

// @lc code=start
class Solution {
    public long findScore(int[] nums) {
        int[][] sortedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            sortedNums[i][0] = nums[i];
            sortedNums[i][1] = i;
        }
        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a[0], b[0]));

        boolean[] marked = new boolean[nums.length];
        long ans = 0L;
        for (int i = 0; i < nums.length; ++i) {
            int idx = sortedNums[i][1];
            if (!marked[idx]) {
                ans += sortedNums[i][0];
                marked[idx] = true;
                if (idx != 0) marked[idx - 1] = true;
                if (idx != nums.length - 1) marked[idx + 1] = true;
            }
        }

        return ans;
    }
}
// @lc code=end


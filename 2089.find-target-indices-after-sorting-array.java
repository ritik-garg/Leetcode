/*
 * @lc app=leetcode id=2089 lang=java
 *
 * [2089] Find Target Indices After Sorting Array
 */

/*
216/216 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.06 % of java submissions (44.5 MB)
*/

// @lc code=start
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0, equal = 0;
        for (int num : nums) {
            if (num < target) less++;
            else if (num == target) equal++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < equal; ++i) ans.add(i + less);
        return ans;
    }
}
// @lc code=end


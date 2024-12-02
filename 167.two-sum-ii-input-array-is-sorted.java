/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

/*
24/24 cases passed (1 ms)
Your runtime beats 99.76 % of java submissions
Your memory usage beats 54.77 % of java submissions (47.1 MB)
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[] {l+1, r+1};
            if (sum < target) {
                int tl = l;
                l++;
                while (l < r && numbers[l] == numbers[tl]) l++;
            } else {
                int tr = r;
                r--;
                while (l < r && numbers[r] == numbers[tr]) r--;
            }
        }
        return new int[] {-1, -1};
    }
}
// @lc code=end


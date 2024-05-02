/*
 * @lc app=leetcode id=2441 lang=java
 *
 * [2441] Largest Positive Integer That Exists With Its Negative
 */

/*
337/337 cases passed (4 ms)
Your runtime beats 91.11 % of java submissions
Your memory usage beats 72.45 % of java submissions (44.6 MB)
 */

// @lc code=start
class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == -nums[right]) return nums[right];
            if (nums[left] * nums[right] > 0) return -1;
            if (-nums[left] > nums[right]) left++;
            else right--;
        }
        return -1;
    }
}
// @lc code=end


/*
By Hashing:
337/337 cases passed (6 ms)
Your runtime beats 64.14 % of java submissions
Your memory usage beats 83.24 % of java submissions (44.6 MB)

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = -1;
        for (int i : nums) {
            set.add(i);
            if (set.contains(-i)) answer = Math.max(answer, Math.abs(i));
        }
        return answer;
    }
}
 */
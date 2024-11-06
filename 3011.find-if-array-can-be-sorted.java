/*
 * @lc app=leetcode id=3011 lang=java
 *
 * [3011] Find if Array Can Be Sorted
 */

/*
999/999 cases passed (2 ms)
Your runtime beats 60 % of java submissions
Your memory usage beats 48.43 % of java submissions (44.3 MB)
 */

// @lc code=start
class Solution {
    public boolean canSortArray(int[] nums) {
        int prevBits = numberOfBits(nums[0]);
        List<Integer> partitions = new ArrayList<>();
        for (int i = 1; i < nums.length; ++i) {
            int currentBits = numberOfBits(nums[i]);
            if (currentBits != prevBits) {
                prevBits = currentBits;
                partitions.add(i - 1);
            }
        }
        partitions.add(nums.length - 1);

        int prevMax = 0, i = 0;
        for (int partition : partitions) {
            int min = Integer.MAX_VALUE, max = 0;
            for (; i <= partition; ++i) {
                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }
            if (min < prevMax) return false;
            prevMax = max;
        }
        return true;
    }

    int numberOfBits(int num) {
        int bits = 0;
        while (num > 0) {
            bits += (num & 1);
            num >>= 1;
        }
        return bits;
    }
}
// @lc code=end


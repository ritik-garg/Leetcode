/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

/**
63/63 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.13 % of java submissions (43.2 MB)
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; --k) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                i--;
            } else {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i--];
                } else {
                    nums1[k] = nums2[j--];
                }
            }
        }
    }
}
// @lc code=end


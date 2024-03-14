/*
 * @lc app=leetcode id=2540 lang=java
 *
 * [2540] Minimum Common Value
 */

/*
41/41 cases passed (2 ms)
Your runtime beats 81.02 % of java submissions
Your memory usage beats 91.93 % of java submissions (62.2 MB)
 */

// @lc code=start
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = 0, n2 = 0;
        while(n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) return nums1[n1];
            else if (nums1[n1] > nums2[n2]) n2++;
            else n1++;
        }
        return -1;
    }
}
// @lc code=end

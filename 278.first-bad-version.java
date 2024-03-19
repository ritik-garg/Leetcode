/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

/*
24/24 cases passed (25 ms)
Your runtime beats 74.97 % of java submissions
Your memory usage beats 62.54 % of java submissions (40.1 MB)
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
// @lc code=end


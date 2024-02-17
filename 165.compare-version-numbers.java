/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

/*
84/84 cases passed (1 ms)
Your runtime beats 82.85 % of java submissions
Your memory usage beats 67.01 % of java submissions (41.4 MB)
*/

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length, l2 = v2.length;
        for(int i = 0; i < Math.max(l2, l1); ++i) {
            int n1 = i < l1 ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < l2 ? Integer.parseInt(v2[i]) : 0;
            if (n1 > n2) return 1;
            else if (n2 > n1) return -1;
        }
        return 0;
    }
}
// @lc code=end


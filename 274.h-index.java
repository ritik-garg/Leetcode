/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

/*
81/81 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 55.16 % of java submissions (41.5 MB)
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] sort = new int[n + 1];
        for (int c : citations) {
            if (c >= n)
                sort[n]++;
            else
                sort[c]++;
        }

        int count = 0;
        for (int i = n; i >= 0; --i) {
            count += sort[i];
            if (count >= i) return i;
        }
        return 0;
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

/*
149/149 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 18.67 % of java submissions (40.7 MB)
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int answer = 0;
        while (num > 0) {
            answer += (num & 1);
            num = num >> 1;
        }
        return answer;
    }
}
// @lc code=end


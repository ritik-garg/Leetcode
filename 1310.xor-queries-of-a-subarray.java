/*
 * @lc app=leetcode id=1310 lang=java
 *
 * [1310] XOR Queries of a Subarray
 */

/*
42/42 cases passed (2 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 24.4 % of java submissions (58.5 MB)
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; ++i) {
            arr[i] ^= arr[i - 1];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; ++i) {
            answer[i] = arr[queries[i][1]];
            if (queries[i][0] != 0) {
                answer[i] ^= arr[queries[i][0] - 1];
            }
        }
        return answer;
    }
}
// @lc code=end


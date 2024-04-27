/*
 * @lc app=leetcode id=514 lang=java
 *
 * [514] Freedom Trail
 */

/*
303/303 cases passed (5 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 95.63 % of java submissions (44.2 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        List<Integer>[] idxList = new List[26];
        for (int i = 0; i < m; ++i) {
            int ch = ring.charAt(i) - 'a';
            if (idxList[ch] == null) idxList[ch] = new ArrayList<>();
            idxList[ch].add(i);
        }

        int[][] dp = new int[m][n];
        return solve(ring.toCharArray(), key.toCharArray(), idxList, 0, 0, dp);
    }

    private int solve (char[] ring, char[] key, List<Integer>[] idxList, int ringIdx, int keyIdx, int[][] dp) {
        int m = ring.length, n = key.length;
        if (keyIdx >= n) return 0;

        if (dp[ringIdx][keyIdx] != 0) return dp[ringIdx][keyIdx];

        int steps = Integer.MAX_VALUE;
        for (int i : idxList[key[keyIdx] - 'a']) {
            int minSteps = Math.min(Math.abs(i - ringIdx), m - Math.abs(i - ringIdx));
            steps = Math.min(steps, minSteps + 1 + solve(ring, key, idxList, i, keyIdx + 1, dp));
        }
        return dp[ringIdx][keyIdx] = steps;
    }
}
// @lc code=end



/*
Without hashmap
303/303 cases passed (9 ms)
Your runtime beats 64.56 % of java submissions
Your memory usage beats 100 % of java submissions (43.8 MB)

class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        int[][] dp = new int[m][n];
        return solve(ring.toCharArray(), key.toCharArray(), 0, 0, dp);
    }

    private int solve (char[] ring, char[] key, int ringIdx, int keyIdx, int[][] dp) {
        int m = ring.length, n = key.length;
        if (keyIdx >= n) return 0;

        if (dp[ringIdx][keyIdx] != 0) return dp[ringIdx][keyIdx];

        int steps = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            if (ring[i] == key[keyIdx]) {
                int minSteps = Math.min(Math.abs(i - ringIdx), m - Math.abs(i - ringIdx));
                steps = Math.min(steps, minSteps + 1 + solve(ring, key, i, keyIdx + 1, dp));
            }
        }
        return dp[ringIdx][keyIdx] = steps;
    }
}
 */
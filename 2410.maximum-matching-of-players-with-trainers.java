/*
 * @lc app=leetcode id=2410 lang=java
 *
 * [2410] Maximum Matching of Players With Trainers
 */

/*
35/35 cases passed (25 ms)
Your runtime beats 95.45 % of java submissions
Your memory usage beats 65.29 % of java submissions (57.7 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int answer = 0, i = 0, j = 0;
        while(i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                answer++;
                i++;
            }
            j++;
        }
        return answer;
    }
}
// @lc code=end


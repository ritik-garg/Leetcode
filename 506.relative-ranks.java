/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 */

/*
18/18 cases passed (7 ms)
Your runtime beats 93.93 % of java submissions
Your memory usage beats 58.39 % of java submissions (45.6 MB)
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = score.length;
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[] {i, score[i]});
        }

        String[] answer = new String[n];
        answer[pq.poll()[0]] = "Gold Medal";
        if (n == 1) return answer;

        answer[pq.poll()[0]] = "Silver Medal";
        if (n == 2) return answer;

        answer[pq.poll()[0]] = "Bronze Medal";
        if (n == 3) return answer;

        for(int i = 4; i <= n; ++i) {
            answer[pq.poll()[0]] = String.valueOf(i);
        }
        return answer;
    }
}
// @lc code=end


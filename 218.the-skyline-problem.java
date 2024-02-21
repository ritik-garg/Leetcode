/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

/*
42/42 cases passed (228 ms)
Your runtime beats 32.23 % of java submissions
Your memory usage beats 49.06 % of java submissions (47.4 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> answer = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        pQueue.offer(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                pQueue.offer(-height[1]);
            } else {
                pQueue.remove(height[1]);
            }

            int current = pQueue.peek();
            if (current != prev) {
                answer.add(Arrays.asList(height[0], current));
                prev = current;
            }
        }
        return answer;
    }
}
// @lc code=end

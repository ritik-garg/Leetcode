/*
 * @lc app=leetcode id=1642 lang=java
 *
 * [1642] Furthest Building You Can Reach
 */

/*
78/78 cases passed (24 ms)
Your runtime beats 10.72 % of java submissions
Your memory usage beats 6.65 % of java submissions (60.3 MB)
 */

// @lc code=start

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1])
                continue;
            bricks -= heights[i + 1] - heights[i];
            pq.add(heights[i + 1] - heights[i]);

            if (bricks < 0) {
                bricks += pq.poll();
                if (ladders > 0)
                    ladders--;
                else
                    return i;
            }
        }

        return heights.length - 1;
    }
}
// @lc code=end

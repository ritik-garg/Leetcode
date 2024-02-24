/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

/*
51/51 cases passed (29 ms)
Your runtime beats 84.11 % of java submissions
Your memory usage beats 5.66 % of java submissions (64.8 MB)
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            } 
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - k + 1 >= 0) {
                answer[i - k + 1] = nums[dq.peek()];
            }
        }
        return answer;
    }
}
// @lc code=end


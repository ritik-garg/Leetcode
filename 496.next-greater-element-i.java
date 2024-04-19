/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

/*
16/16 cases passed (3 ms)
Your runtime beats 90.22 % of java submissions
Your memory usage beats 15.85 % of java submissions (44.3 MB)
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }

        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            answer[i] = map.get(nums1[i]);
        }
        return answer;
    }
}
// @lc code=end


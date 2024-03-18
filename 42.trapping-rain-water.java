/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

/*
322/322 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 49.05 % of java submissions (46.2 MB)
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        int leftMax = height[0], rightMax = height[n - 1];
        int left = 0, right = n - 1, answer = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                answer += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                answer += rightMax - height[right--];
            }
        }
        return answer;
    }
}
// @lc code=end



/*
Solution with storing left and right maxes as arrays:

322/322 cases passed (1 ms)
Your runtime beats 71.19 % of java submissions
Your memory usage beats 90.24 % of java submissions (45.6 MB)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2)
            return 0;
        int[] leftMax = new int[n], rightMax = new int[n];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i]);
        }

        int answer = 0;
        for (int i = 0; i < n; ++i) {
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            answer += water > 0 ? water : 0;
        }
        return answer;
    }
}
 */
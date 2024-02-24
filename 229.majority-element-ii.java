/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

/*
89/89 cases passed (2 ms)
Your runtime beats 99.28 % of java submissions
Your memory usage beats 14.35 % of java submissions (48.4 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] == candidate1) count1++; 
            else if (nums[i] == candidate2) count2++; 
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;
        int thresold = nums.length / 3;
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] == candidate1) count1++;
            else if (nums[i] == candidate2) count2++;
        }
        
        List<Integer> answer = new ArrayList<>();
        if (count1 > thresold) answer.add(candidate1);
        if (count2 > thresold) answer.add(candidate2);
        return answer;
    }
}
// @lc code=end


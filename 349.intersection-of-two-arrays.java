/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

/*
56/56 cases passed (2 ms)
Your runtime beats 93.47 % of java submissions
Your memory usage beats 68.16 % of java submissions (43 MB)
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] freq = new boolean[1001];
        for (int num : nums1) {
            freq[num] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int num : nums2) {
            if (freq[num]) {
                answer.add(num);
                freq[num] = false;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end

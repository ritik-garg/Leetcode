/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

/*
30/30 cases passed (122 ms)
Your runtime beats 8.81 % of java submissions
Your memory usage beats 29.36 % of java submissions (61.9 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<int[]> seen = new TreeSet<>(Arrays::compare);
        pq.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        int n1 = nums1.length, n2 = nums2.length;
        while (k-- > 0 && !pq.isEmpty()) {
            int[] minPair = pq.poll();
            int idx1 = minPair[1], idx2 = minPair[2];
            answer.add(Arrays.asList(nums1[idx1], nums2[idx2]));
            if (idx2 + 1 < n2) {
                int[] next = new int[] {nums1[idx1] + nums2[idx2 + 1], idx1, idx2 + 1};
                if (!seen.contains(next)) {
                    pq.offer(next);
                    seen.add(next);
                }
            } 
            if (idx1 + 1 < n1) {
                int[] next = new int[] {nums1[idx1 + 1] + nums2[idx2], idx1 + 1, idx2};
                if (!seen.contains(next)) {
                    pq.offer(next);
                    seen.add(next);
                }
            }
        }
        return answer;
    }
}
// @lc code=end


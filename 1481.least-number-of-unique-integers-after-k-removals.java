/*
 * @lc app=leetcode id=1481 lang=java
 *
 * [1481] Least Number of Unique Integers after K Removals
 */

/*
 * 43/43 cases passed (32 ms)
 * Your runtime beats 97.51 % of java submissions
 * Your memory usage beats 88.99 % of java submissions (56.4 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k == arr.length) {
            return 0;
        }

        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int remaining = freq.size();
        if (k == 0) {
            return remaining;
        }

        int[] freqCount = new int[arr.length + 1];
        for (int f : freq.values()) {
            freqCount[f]++;
        }

        for(int i = 0; i <= arr.length; ) {
            if (freqCount[i] > 0) {
                freqCount[i]--;
                k -= i;
                remaining--;
            } else {
                i++;
            }
            if (k < 0) {
                return remaining + 1;
            } else if (k == 0) {
                return remaining;
            }
        }
        return remaining;
    }
}
// @lc code=end


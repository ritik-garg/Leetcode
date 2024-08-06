/*
 * @lc app=leetcode id=3016 lang=java
 *
 * [3016] Minimum Number of Pushes to Type Word II
 */

/*
877/877 cases passed (17 ms)
Your runtime beats 40.77 % of java submissions
Your memory usage beats 45.19 % of java submissions (45.7 MB)
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int minimumPushes(String word) {
        Integer[] frequency = new Integer[26];
        for (int i = 0; i < 26; ++i) frequency[i] = 0;
        for (char ch : word.toCharArray()) {
            frequency[ch - 'a']++;
        }
        Arrays.sort(frequency, Comparator.reverseOrder());

        int keyPress = 0;
        for (int i = 0; i < 26; ++i) {
            keyPress += (i / 8 + 1) * frequency[i];
        }
        return keyPress;
    }
}
// @lc code=end


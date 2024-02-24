/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

/*
267/267 cases passed (15 ms)
Your runtime beats 55.68 % of java submissions
Your memory usage beats 42.66 % of java submissions (45.1 MB)
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) return "";

        Map<Character,Integer> freqT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }
        int required = freqT.size();

        Map<Character,Integer> freqS = new HashMap<>();
        int l = 0, r = 0, got = 0;
        int[] answer = {-1, 0, 0};
        while (r < m) {
            char ch = s.charAt(r);
            freqS.put(ch, freqS.getOrDefault(ch, 0) + 1);

            if (freqT.containsKey(ch) && freqS.get(ch).intValue() == freqT.get(ch).intValue()) got++;

            while (got == required && l <= r) {
                char temp = s.charAt(l);
                freqS.put(temp, freqS.get(temp) - 1);

                if (freqT.containsKey(temp) && freqS.get(temp).intValue() < freqT.get(temp).intValue()) {
                    got--;
                    if (answer[0] == -1 || (r - l + 1) < answer[0]) {
                        answer[0] = r - l + 1;
                        answer[2] = r + 1;
                        answer[1] = l;
                    }
                }
                l++;
            }
            r++;
        }
        return answer[0] == -1 ? "" : s.substring(answer[1], answer[2]);
    }
}
// @lc code=end


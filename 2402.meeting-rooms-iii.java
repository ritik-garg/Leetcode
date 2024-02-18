/*
 * @lc app=leetcode id=2402 lang=java
 *
 * [2402] Meeting Rooms III
 */

/*
82/82 cases passed (63 ms)
Your runtime beats 91.05 % of java submissions
Your memory usage beats 28.93 % of java submissions (100.6 MB)
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        if (n == 1) return 0;
        int[] count = new int[n];
        long[] meetingEnds = new long[n];
        int maxIndex = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < meetings.length; ++i) {
            int start = meetings[i][0], end = meetings[i][1];
            int minIndex = 0;
            boolean isScheduled = false;
            for(int j = 0; j < n; ++j) {
                if (meetingEnds[j] <= start) {
                    count[j]++;
                    meetingEnds[j] = end;
                    isScheduled = true;
                    if (count[maxIndex] == count[j]) {
                        maxIndex = Math.min(maxIndex, j);
                    } else if (count[maxIndex] < count[j]) {
                        maxIndex = j;
                    }
                    break;
                } else {
                    minIndex = meetingEnds[j] < meetingEnds[minIndex] ? j : minIndex;
                }
            }

            if (!isScheduled) {
                count[minIndex]++;
                meetingEnds[minIndex] = meetingEnds[minIndex] + end - start;
                if (count[maxIndex] == count[minIndex]) {
                    maxIndex = Math.min(maxIndex, minIndex);
                } else if (count[maxIndex] < count[minIndex]) {
                    maxIndex = minIndex;
                }
            }
        }

        return maxIndex;
    }
}
// @lc code=end


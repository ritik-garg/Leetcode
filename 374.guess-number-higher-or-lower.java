/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

/*
25/25 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 55.35 % of java submissions (40.2 MB)
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pick = guess(mid);
            if (pick == 0) return mid;
            else if (pick == -1) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
// @lc code=end


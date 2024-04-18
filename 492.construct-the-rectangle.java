/*
 * @lc app=leetcode id=492 lang=java
 *
 * [492] Construct the Rectangle
 */

/*
52/52 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 76.66 % of java submissions (40.6 MB)
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[] {area / w, w};
    }
}
// @lc code=end

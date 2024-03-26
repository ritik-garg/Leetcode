/*
 * @lc app=leetcode id=1700 lang=java
 *
 * [1700] Number of Students Unable to Eat Lunch
 */

/*
55/55 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 97.49 % of java submissions (40.9 MB)
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        boolean[] b = new boolean[students.length];
        int l = 0, i = 0, j = 0;
        while(j < sandwiches.length) {
            if(b[i] == false && students[i] == sandwiches[j]) {
                l = i;
                b[i] = true;
                j++;
            }
            i++;
            if(i == students.length) i = 0;
            if (i == l) {
                return sandwiches.length - j;
            }
        }
        return 0;
    }
}
// @lc code=end


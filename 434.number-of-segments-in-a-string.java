/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */

/*
28/28 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 71.5 % of java submissions (41 MB)
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        int res=0;
        char[] str = s.toCharArray();
        for(int i=0; i < str.length; i++)
            if(str[i] != ' ' && (i == 0 || str[i - 1] == ' ')) 
                res++;
        return res;
    }
}
// @lc code=end


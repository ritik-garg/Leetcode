/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

/*
54/54 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 27.38 % of java submissions (41.9 MB)
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int num = 0;
        for(int ch : t.toCharArray()){
            num += ch;
        }
        for(int ch : s.toCharArray()){
            num -= ch;
        }
        return (char) num;
    }
}
// @lc code=end


/*
Frequency Map Solution
54/54 cases passed (2 ms)
Your runtime beats 68.24 % of java submissions
Your memory usage beats 68.52 % of java submissions (41.7 MB)

class Solution {
    public char findTheDifference(String s, String t) {
        int[] fs = new int[26], ft = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            fs[s.charAt(i) - 'a']++;
            ft[t.charAt(i) - 'a']++;
        }
        ft[t.charAt(s.length()) - 'a']++;

        for(int i = 0; i < 26; ++i) {
            if (fs[i] != ft[i]) {
                return (char)(i + 'a');
            }
        }
        return '.';
    }
}

 */

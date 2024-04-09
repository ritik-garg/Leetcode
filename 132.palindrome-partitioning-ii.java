/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

/*
37/37 cases passed (14 ms)
Your runtime beats 97.9 % of java submissions
Your memory usage beats 34.44 % of java submissions (46.8 MB)
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
// @lc code=end


/*
n^3 solution
Time Limit Exceeded
37/37 cases passed (N/A)

class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[][] pal = new int[n][n];

        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0; i < n - gap; ++i) {
                int j = i + gap;
                if (isPalindrome(str, i, j, pal)) continue;
                
                int cuts = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    cuts = Math.min(cuts, pal[i][k] + pal[k + 1][j]);
                }
                pal[i][j] = cuts == Integer.MAX_VALUE ? 1 : cuts + 1;
            }
        }

        return pal[0][n - 1];
    }

    private boolean isPalindrome(char[] str, int i, int j, int[][] pal) {
        if (i == j) return true;
        if (j == i + 1) return str[i] == str[j];
        return str[i] == str[j] && pal[i + 1][j - 1] == 0;
    }
}
 */
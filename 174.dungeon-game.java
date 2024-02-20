/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

/*
45/45 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 29.69 % of java submissions (45.3 MB)
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] mem = new int[m][n];
        mem[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : Math.abs(dungeon[m - 1][n - 1]) + 1;
        return helper(dungeon, mem, 0, 0);
    }

    private int helper(int[][] dungeon, int[][] mem, int x, int y) {
        if (x >= dungeon.length || y >= dungeon[0].length)
            return Integer.MAX_VALUE;
        if (mem[x][y] > 0)
            return mem[x][y];

        int health = helper(dungeon, mem, x + 1, y);
        health = Math.min(helper(dungeon, mem, x, y + 1), health);

        mem[x][y] = health <= dungeon[x][y] ? 1 : health - dungeon[x][y];
        return mem[x][y];
    }
}
// @lc code=end

/*
 * Using DP
 * 45/45 cases passed (3 ms)
 * Your runtime beats 39.32 % of java submissions
 * Your memory usage beats 90.17 % of java submissions (44 MB)
 * 
 * public int calculateMinimumHP(int[][] dungeon) {
 * int m = dungeon.length, n = dungeon[0].length;
 * for(int i = m - 1; i >= 0; --i) {
 * for(int j = n - 1; j >= 0; --j) {
 * if(i == m - 1 && j == n - 1) dungeon[i][j] = minHP(dungeon[i][j] - 1);
 * else if (i == m - 1) dungeon[i][j] = minHP(dungeon[i][j] - dungeon[i][j +
 * 1]);
 * else if (j == n - 1) dungeon[i][j] = minHP(dungeon[i][j] - dungeon[i +
 * 1][j]);
 * else dungeon[i][j] = Math.min(minHP(dungeon[i][j] - dungeon[i][j + 1]),
 * minHP(dungeon[i][j] - dungeon[i + 1][j]));
 * }
 * }
 * return dungeon[0][0];
 * }
 * 
 * private int minHP(int value) {
 * if (value < 0) return Math.abs(value);
 * else return 1;
 * }
 */

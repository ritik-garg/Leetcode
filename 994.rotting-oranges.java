/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

/*
307/307 cases passed (2 ms)
Your runtime beats 68.66 % of java submissions
Your memory usage beats 16.32 % of java submissions (43 MB)
 */

// @lc code=start
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }
        q.add(new int[] {-1, -1});

        int time = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == -1) {
                time++;
                if (!q.isEmpty()) {
                    q.add(c);
                }
                continue;
            }

            for (int[] d : dir) {
                int[] nc = {c[0] + d[0], c[1] + d[1]};
                if (valid(grid, nc, m, n)) {
                    grid[nc[0]][nc[1]] = 2;
                    q.add(nc);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time - 1;
    }

    private boolean valid(int[][] grid, int[] c, int m, int n) {
        return c[0] >= 0 && c[0] < m && c[1] >= 0 && c[1] < n && grid[c[0]][c[1]] == 1; 
    }
}
// @lc code=end


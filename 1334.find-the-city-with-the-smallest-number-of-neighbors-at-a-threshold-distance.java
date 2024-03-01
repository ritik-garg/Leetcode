/*
 * @lc app=leetcode id=1334 lang=java
 *
 * [1334] Find the City With the Smallest Number of Neighbors at a Threshold Distance
 */

/*
54/54 cases passed (8 ms)
Your runtime beats 91.61 % of java submissions
Your memory usage beats 75.22 % of java submissions (44.1 MB)
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 1. Graph creation
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(graph[i], 10001);
            graph[i][i] = 0;
        }
        for(int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        // 2. Floyd Warshal Algotithm
        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 3. Finding minimum answer
        int answer = -1, minValue = 10001;
        for(int i = 0; i < n; ++i) {
            int count = 0;
            for(int j = 0; j < n; ++j) {
                if (graph[i][j] <= distanceThreshold) count++;
            }
            if (minValue >= count) {
                minValue = count;
                answer = i;
            }
        }
        return answer;
    }
}
// @lc code=end


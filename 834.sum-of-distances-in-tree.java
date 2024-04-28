/*
 * @lc app=leetcode id=834 lang=java
 *
 * [834] Sum of Distances in Tree
 */

/*
74/74 cases passed (52 ms)
Your runtime beats 49.14 % of java submissions
Your memory usage beats 67.24 % of java submissions (65.5 MB)
 */

// @lc code=start
class Solution {
    private Map<Integer, List<Integer>> graph;
    private int[] count;
    private int[] res;

    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(child, node);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new HashMap<>();
        count = new int[n];
        res = new int[n];
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }
}
// @lc code=end



/*
Using Prim's Algorithm
Memory Limit Exceeded
64/74 cases passed (N/A)


class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
            graph[i][i] = 0;
        }
        for (int i = 0; i < edges.length; ++i) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                answer[i] += graph[i][j];
            }
        }
        return answer;
    }
}
 */
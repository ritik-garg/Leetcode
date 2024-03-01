/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

/*
28/28 cases passed (1 ms)
Your runtime beats 97.9 % of java submissions
Your memory usage beats 64.41 % of java submissions (42.1 MB)
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            List<String> equation = equations.get(i);
            List<Pair<String,Double>> list = adjList.getOrDefault(equation.get(0), new ArrayList<>());
            list.add(new Pair(equation.get(1), values[i]));
            adjList.putIfAbsent(equation.get(0), list);
            
            list = adjList.getOrDefault(equation.get(1), new ArrayList<>());
            list.add(new Pair(equation.get(0), 1.0 / values[i]));
            adjList.putIfAbsent(equation.get(1), list);
        }

        double[] answer = new double[queries.size()];
        for(int i = 0; i < answer.length; ++i) {
            List<String> query = queries.get(i);
            if (adjList.containsKey(query.get(0)) && adjList.containsKey(query.get(1))) {
                Set<String> visited = new HashSet<>();
                double[] ans = new double[1];
                ans[0] = -1.0;
                dfs(query.get(0), query.get(1), adjList, visited, ans, 1.0);
                answer[i] = ans[0];
            } else {
                answer[i] = -1.0;
            }
        }
        return answer;
    }

    private void dfs(String start, String end, Map<String,List<Pair<String,Double>>> adjList, Set<String> visited, double[] ans, double division) {
        if (start.equals(end)) {
            ans[0] = division;
            return;
        }
        for (Pair<String,Double> next : adjList.get(start)) {
            if (!visited.contains(next.getKey())) {
                visited.add(next.getKey());
                dfs(next.getKey(), end, adjList, visited, ans, division * next.getValue());
                visited.remove(next.getKey());
            }
        }
    }
}
// @lc code=end

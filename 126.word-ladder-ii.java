/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

/*
Time Limit Exceeded
32/36 cases passed (N/A)
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String,Integer> visited = new HashMap<>();
        visited.put(beginWord, 0);
        Map<String, List<String>> graph = new HashMap<>();

        int depth = 0, minDepth = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String currentWord = queue.poll();
                graph.put(currentWord, new ArrayList<>());
                if (currentWord.equals(endWord)) {
                    minDepth = Math.min(minDepth, depth + 1);
                    continue;
                }

                List<String> neighbors = graph.get(currentWord);
                for (int j = 0; j < currentWord.length(); ++j) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        StringBuilder sb = new StringBuilder(currentWord);
                        sb.setCharAt(j, ch);
                        String word = sb.toString();
                        if (!currentWord.equals(word) && wordSet.contains(word) && (!visited.containsKey(word) || visited.get(word) >= depth)) {
                            if (!visited.containsKey(word)) queue.add(word);
                            if (!word.equals(endWord)) visited.put(word, depth);
                            neighbors.add(word);
                        }
                    }
                }
                graph.put(currentWord, neighbors);
            } 
            depth++;  
        }

        System.out.println(graph);
        
        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, minDepth, path, graph, answer);
        return answer;
    }

    private void dfs(String current, String endWord, int depth, List<String> path, Map<String, List<String>> graph, List<List<String>> answer) {
        if (path.size() == depth) return;
        for (String word : graph.get(current)) {
            path.add(word);
            if (word.equals(endWord)) {
                answer.add(new ArrayList<>(path));
            }
            if (depth != path.size()) {
                dfs(word, endWord, depth, path, graph, answer);
            }
            path.removeLast();
        }
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

/*
22/22 cases passed (27 ms)
Your runtime beats 40.79 % of java submissions
Your memory usage beats 73.53 % of java submissions (42.6 MB)
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] visited = new Node[101];
        return dfs(node, visited);
    }

    private Node dfs(Node node, Node[] visited) {
        if (visited[node.val] != null) return visited[node.val];
        Node newNode = new Node(node.val);
        visited[node.val] = newNode;
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, visited));
        }
        return newNode;
    }
}
// @lc code=end


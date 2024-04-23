/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

/*
29/29 cases passed (174 ms)
Your runtime beats 78.34 % of java submissions
Your memory usage beats 93.14 % of java submissions (85.8 MB)
 */

// @lc code=start
class Node {
    boolean end = false;
    Node[] nodes = new Node[26];
}

class WordDictionary {
    Node trie;

    public WordDictionary() {
        trie = new Node();    
    }
    
    public void addWord(String word) {
        Node ptr = trie;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (ptr.nodes[idx] == null) ptr.nodes[idx] = new Node();
            ptr = ptr.nodes[idx];
        } 
        ptr.end = true;
    }
    
    public boolean search(String word) {
        return search(word.toCharArray(), 0, trie);
    }

    private boolean search (char[] word, int i, Node ptr) {
        for (int j = i; j < word.length; ++j) {
            int idx = word[j] - 'a';
            if (word[j] != '.') {
                if (ptr.nodes[idx] == null) return false;
                else ptr = ptr.nodes[idx];
            } else {
                for (Node node : ptr.nodes) {
                    if (j < word.length - 1 && node != null && search(word, j + 1, node)) return true;
                    if (j == word.length - 1 && node != null && node.end) return true;
                }
                return false;
            }
        }
        return ptr.end;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end


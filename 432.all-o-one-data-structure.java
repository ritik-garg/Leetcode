/*
 * @lc app=leetcode id=432 lang=java
 *
 * [432] All O`one Data Structure
 */

/*
18/18 cases passed (58 ms)
Your runtime beats 28.57 % of java submissions
Your memory usage beats 10.53 % of java submissions (61.6 MB)
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    int frequency;
    Set<String> strings;
    Node prev, next;

    Node(int f, Set<String> set) {
        frequency = f;
        strings = set;
    }

    public void addString(String key) {
        if (strings == null) strings = new HashSet<>();
        strings.add(key);
    }

    public boolean removeString(String key) {
        strings.remove(key);
        return strings.isEmpty();
    }

    public String returnAnyString() {
        return strings.iterator().next();
    }
}

class CircularHashedDLL {
    Node dummy;
    Map<Integer, Node> nodeMap;

    CircularHashedDLL() {
        dummy = new Node(0, null);
        dummy.next = dummy.prev = dummy;
        nodeMap = new HashMap<>();
        nodeMap.put(0, dummy);
    }

    private void insertInDLL(Node node, Node parent) {
        Node nextNode = parent.next;
        node.next = nextNode;
        nextNode.prev = node;
        parent.next = node;
        node.prev = parent;
    }

    public void addString(String key, int frequency) {
        if (nodeMap.containsKey(frequency)) {
            nodeMap.get(frequency).addString(key);
        } else {
            Node node = new Node(frequency, new HashSet<>(Arrays.asList(key)));
            nodeMap.put(frequency, node);
            Node parent;
            if (nodeMap.containsKey(frequency - 1)) {
                parent = nodeMap.get(frequency - 1);
            } else {
                parent = nodeMap.get(frequency + 1).prev;
            }
            insertInDLL(node, parent);
        }
    }

    private void removeFromDLL(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void removeString(String key, int frequency) {
        Node node = nodeMap.get(frequency);
        boolean isSetEmpty = node.removeString(key);
        if (isSetEmpty) {
            nodeMap.remove(frequency);
            removeFromDLL(node);
        }
    }

    public String returnMaxString() {
        Node maxNode = dummy.prev;
        if (dummy == maxNode) return "";
        return maxNode.returnAnyString();
    }

    public String returnMinString() {
        Node minNode = dummy.next;
        if (dummy == minNode) return "";
        return minNode.returnAnyString();
    }
}

class AllOne {
    Map<String, Integer> frequencyMap;
    CircularHashedDLL circularHashedDLL;

    public AllOne() {
        frequencyMap = new HashMap<>();
        circularHashedDLL = new CircularHashedDLL();
    }

    public void inc(String key) {
        if (frequencyMap.containsKey(key)) {
            int oldFrequency = frequencyMap.get(key);
            frequencyMap.put(key, oldFrequency + 1);
            circularHashedDLL.addString(key, oldFrequency + 1);
            circularHashedDLL.removeString(key, oldFrequency);
        } else {
            frequencyMap.put(key, 1);
            circularHashedDLL.addString(key, 1);
        }
    }

    public void dec(String key) {
        int oldFrequency = frequencyMap.get(key);
        if (oldFrequency == 1) {
            frequencyMap.remove(key);
        } else {
            frequencyMap.put(key, oldFrequency - 1);
            circularHashedDLL.addString(key, oldFrequency - 1);
        }
        circularHashedDLL.removeString(key, oldFrequency);
    }

    public String getMaxKey() {
        return circularHashedDLL.returnMaxString();
    }

    public String getMinKey() {
        return circularHashedDLL.returnMinString();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

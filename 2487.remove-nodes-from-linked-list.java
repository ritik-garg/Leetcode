/*
 * @lc app=leetcode id=2487 lang=java
 *
 * [2487] Remove Nodes From Linked List
 */

/*
32/32 cases passed (20 ms)
Your runtime beats 36.69 % of java submissions
Your memory usage beats 97.38 % of java submissions (61.1 MB)
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        List<ListNode> stack = new ArrayList<>();
        while (head != null) {
            while (!stack.isEmpty() && stack.get(stack.size() - 1).val < head.val) {
                stack.removeLast();
            }
            stack.add(head);
            head = head.next;
        }

        ListNode newHead = stack.get(0);
        ListNode ptr = newHead;
        for (int i = 1; i < stack.size(); ++i) {
            ptr.next = stack.get(i);
            ptr = stack.get(i);
        }
        ptr.next = null;
        return newHead;
    }
}
// @lc code=end


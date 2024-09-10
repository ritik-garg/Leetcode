/*
 * @lc app=leetcode id=2807 lang=java
 *
 * [2807] Insert Greatest Common Divisors in Linked List
 */

/*
582/582 cases passed (2 ms)
Your runtime beats 71.11 % of java submissions
Your memory usage beats 61.64 % of java submissions (45 MB)
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
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void insertGcd(ListNode node1, ListNode node2) {
        int val = node1.val > node2.val ? gcd(node1.val, node2.val) : gcd(node2.val, node1.val);
        node1.next = new ListNode(val, node2);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            insertGcd(ptr, ptr.next);
            ptr = ptr.next.next;
        }
        return head;
    }

}
// @lc code=end


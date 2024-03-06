/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

/*
26/26 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 87.92 % of java submissions (44.1 MB)
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
// @lc code=end


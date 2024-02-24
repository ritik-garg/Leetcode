/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

/*
39/39 cases passed (1 ms)
Your runtime beats 99.93 % of java submissions
Your memory usage beats 49.51 % of java submissions (48.6 MB)
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;
        while (ptr1 != ptr2) {
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }

        return ptr1;
    }
}
// @lc code=end

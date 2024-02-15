/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

/* 
 * 1568/1568 cases passed (1 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 34.51 % of java submissions (44.6 MB)
*/

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode ptr = answer;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum =  carry;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;

            ListNode node = new ListNode(sum % 10);
            ptr.next = node;
            ptr = node;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            carry = sum / 10;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            ptr.next = node;
            ptr = node;
        }

        return answer.next;
    }
}
// @lc code=end

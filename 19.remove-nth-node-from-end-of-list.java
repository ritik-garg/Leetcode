/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

/*
208/208 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 79.58 % of java submissions (43 MB)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t = new ListNode(0, head);
        ListNode s = t, f = t;
        for (int i = 0; i < n; ++i) f = f.next;
        while (f.next != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return t.next;
    }
}
// @lc code=end

/*
208/208 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 62.87 % of java submissions (41.5 MB)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head, left = head;
        while (n-- > 0) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        } else {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
*/
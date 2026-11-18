/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

/*
12/12 cases passed (2 ms)
Your runtime beats 90.24 % of java submissions
Your memory usage beats 77.52 % of java submissions (48.7 MB)
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
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) return;
        ListNode h2 = split(head);
        h2 = reverse(h2);
        head = merge(head, h2);
    }

    private ListNode split(ListNode head) {
        ListNode s = head, f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode t = s.next;
        s.next = null;
        return t;
    }

    private ListNode reverse(ListNode head) {
        ListNode p = null;
        while (head.next != null) {
            ListNode n = head.next;
            head.next = p;
            p = head;
            head = n;
        }
        head.next = p;
        return head;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode m = new ListNode();
        ListNode p = m;
        while (h1 != null && h2 != null) {
            p.next = h1;
            h1 = h1.next;
            p = p.next;
            p.next = h2;
            h2 = h2.next;
            p = p.next;
        }
        p.next = h1;
        return m.next;
    }
}
// @lc code=end


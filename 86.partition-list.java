/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

/*
168/168 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 78.76 % of java submissions (41.7 MB)
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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(), greater = new ListNode();
        ListNode ptr = head, lptr = less, gptr = greater;
        while (ptr != null) {
            if (ptr.val < x) {
                lptr.next = ptr;
                lptr = ptr;
            } else {
                gptr.next = ptr;
                gptr = ptr;
            }
            ptr = ptr.next;
        }
        gptr.next = null;
        lptr.next = greater.next;
        return less.next;
    }
}
// @lc code=end


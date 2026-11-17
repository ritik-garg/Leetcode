/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

/*
28/28 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 91.28 % of java submissions (43.6 MB)
*/

// @lc code=start
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, n = head.next;
        head.next = null;
        while (n != null) {
            ListNode t = n.next;
            n.next = p;
            p = n;
            n = t;
        }
        return p;
    }
}
// @lc code=end

/*

Recursive Method
28/28 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 84.62 % of java submissions (42.2 MB)

class Solution {
    // public ListNode reverseList(ListNode head) {
    //     // Iterative Method
    //     if(head == null || head.next == null) return head;
        
    //     ListNode prev = null, curr = head, next = curr.next;

    //     while(next != null) {
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //         next = curr.next;
    //     }
    //     curr.next = prev;
    //     return curr;
    // }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode next = head.next;
        head.next = prev;
        return reverseListRecursive(next, head);
    }
}
*/
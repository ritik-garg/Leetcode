/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

/*
134/134 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 90.9 % of java submissions (44.1 MB)
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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        ListNode left = end == start + 1 ? lists[start] : merge(lists, start, mid);
        ListNode right = end == start + 1 ? lists[end] : merge(lists, mid + 1, end);
        return merge2Lists(left, right);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode ptr = answer;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (l1 != null) ptr.next = l1;
        else ptr.next = l2;

        return answer.next;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

/*
208/208 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 93.08 % of java submissions (43.6 MB)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                p.next = list2;
                list2 = null;
            } else if (list2 == null) {
                p.next = list1;
                list1 = null;
            } else if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }
        }
        return ans.next;
    }
}
// @lc code=end


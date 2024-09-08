/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
 */

/*
43/43 cases passed (0 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 94.23 % of java submissions (43.1 MB)
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }

        int split = len / k;
        ListNode[] answer = new ListNode[k];
        int i = 0;
        ptr = head;
        while (i < len % k) {
            answer[i] = ptr;
            for (int j = 1; j < split + 1; ++j) {
                ptr = ptr.next;
            }
            ListNode next = ptr.next;
            ptr.next = null;
            ptr = next;
            i++;
        }
        while (i < k) {
            answer[i] = ptr;
            for (int j = 1; j < split; ++j) {
                ptr = ptr.next;
            }
            if (ptr == null) break;
            ListNode next = ptr.next;
            ptr.next = null;
            ptr = next;
            i++;
        }

        return answer;
    }
}
// @lc code=end


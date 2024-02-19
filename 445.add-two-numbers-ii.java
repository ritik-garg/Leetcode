/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 */

/*
1563/1563 cases passed (1 ms)
Your runtime beats 100 % of java submissions
Your memory usage beats 64.96 % of java submissions (44.4 MB)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = length(l1), n2 = length(l2);
        ListNode answer = n1 >= n2 ? add(l1, n1, l2, n2) : add(l2, n2, l1, n1);
        if (answer.val >= 10) {
            ListNode node = new ListNode(answer.val / 10, answer);
            answer.val %= 10;
            answer = node;
        }
        return answer;
    }

    private ListNode add(ListNode l1, int n1, ListNode l2, int n2) {
        if (l1 == null) return null;
        if (n1 > n2) {
            ListNode sum = add(l1.next, n1 - 1, l2, n2);
            int carry = 0;
            if (sum != null) {
                carry = sum.val / 10;
                sum.val %= 10;
            }
            l1.val += carry;
            l1.next = sum;
        } else {
            ListNode sum = add(l1.next, n1 - 1, l2.next, n2 - 1);
            int carry = 0;
            if (sum != null) {
                carry = sum.val / 10;
                sum.val %= 10;
            }
            l1.val += carry + l2.val;
            l1.next = sum;
        }
        return l1;
    }

    private int length(ListNode l) {
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=2326 lang=java
 *
 * [2326] Spiral Matrix IV
 */

/*
50/50 cases passed (8 ms)
Your runtime beats 37.87 % of java submissions
Your memory usage beats 49.51 % of java submissions (56.7 MB
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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while(left <= right && top <= bottom) {
            for (int i = left; top <= bottom && i <= right; ++i) {
                answer[top][i] = getHeadValue(head);
                head = getNextHead(head);
            }
            top++;
            for (int i = top; left <= right && i <= bottom; ++i) {
                answer[i][right] = getHeadValue(head);
                head = getNextHead(head);
            }
            right--;
            for (int i = right; top <= bottom && i >= left; --i) {
                answer[bottom][i] = getHeadValue(head);
                head = getNextHead(head);
            }
            bottom--;
            for (int i = bottom; left <= right && i >= top; --i) {
                answer[i][left] = getHeadValue(head);
                head = getNextHead(head);
            }
            left++;
        }
        return answer;
    }

    private int getHeadValue(ListNode head) {
        return head != null ? head.val : -1;
    }

    private ListNode getNextHead(ListNode head) {
        return head != null ? head.next : head;
    }
}
// @lc code=end


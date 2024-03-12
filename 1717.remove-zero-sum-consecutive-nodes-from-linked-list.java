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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode ptr = head;
        int sum = 0;
        while(ptr != null) {
            sum += ptr.val;
            if (sum == 0) {
                head = ptr.next;
                map.clear();
            } else if (map.containsKey(sum)) {
                ListNode prev = map.get(sum);
                if (ptr != prev.next) {
                    ListNode remove = prev.next;
                    int prevSum = sum + remove.val;
                    while(remove != ptr) {
                        map.remove(prevSum);
                        remove = remove.next;
                        prevSum += remove.val;
                    }
                }
                prev.next = ptr.next;
            } else {
                map.put(sum, ptr);
            }
            ptr = ptr.next;
        }
        return head;
    }
}
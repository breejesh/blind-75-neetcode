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
        int len = 0;
        ListNode iter = head;
        while (iter != null) {
            iter = iter.next;
            len++;
        }
        if (len == 1) {
            return null;
        }
        if (len - n - 1 < 0) {
            head = head.next;
            return head;
        }
        iter = head;
        for (int i = 0; i <= len - n - 1; i++) {
            if (i == (len - n) - 1) {
                if (iter.next != null) {
                    iter.next = iter.next.next;
                } else {
                    iter.next = null;
                }
            } else {
                iter = iter.next;
            }
        }
        return head;
    }
}

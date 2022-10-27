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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        return reverseRecursive(null, head);
    }
    
    private ListNode reverseRecursive(ListNode prev, ListNode iter) {
        if(iter.next != null) {
            ListNode head = reverseRecursive(iter, iter.next);
            iter.next = prev;     
            return head;
        } else {
            iter.next = prev;
            return iter;
        }
    }
}
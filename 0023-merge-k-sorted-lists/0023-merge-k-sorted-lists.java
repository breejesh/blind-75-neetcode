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
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));
        ListNode head = null;
        ListNode iter = null;
        for (ListNode listHead : lists) {
            if (listHead != null) {
                queue.add(listHead);
            }
        }
        while (!queue.isEmpty()) {
            if (head == null) {
                head = queue.poll();
                iter = head;
            } else {
                iter.next = queue.poll();
                iter = iter.next;
            }
            if (iter.next != null) {
                queue.add(iter.next);
            }
        }
        return head;
    }
}

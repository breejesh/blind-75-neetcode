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

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList();
        ListNode iter = head;
        while (iter != null) {
            nodes.add(iter);
            iter = iter.next;
        }
        if(nodes.size() == 1) {
            return;
        }
        for (int i = 0; i <= (nodes.size()) / 2; i++) {
            ListNode startOrderNode = nodes.get(i);
            if ((nodes.size())/2 != i) {
                ListNode endOrderNode = nodes.get(nodes.size() - 1 - i);
                endOrderNode.next = startOrderNode.next;
                startOrderNode.next = endOrderNode;
            } else {
                startOrderNode.next = null;
            }
        }
    }    
}

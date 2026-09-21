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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            while (node != null) {
                minHeap.offer(node);
                node = node.next;
            }
        }

        if (minHeap.isEmpty()) return null;

        ListNode head = minHeap.poll();
        ListNode current = head;

        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
        }

        current.next = null;

        return head;
    }
}

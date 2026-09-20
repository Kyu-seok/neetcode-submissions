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
        PriorityQueue<ListNode> minHeap =  new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode listNode : lists) {
            while (listNode != null) {
                minHeap.offer(listNode);
                listNode = listNode.next;
            }
        }

        if (minHeap.isEmpty()) return null;

        ListNode head = minHeap.poll();
        ListNode curr = head;

        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }
}

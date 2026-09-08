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
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }


        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode firstNext = first.next;
            first.next = second;
            first = firstNext;

            ListNode secondNext = second.next;
            second.next = first;
            second = secondNext;
        }
    }
}

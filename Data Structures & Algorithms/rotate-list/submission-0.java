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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head;
        int size = 1;

        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k %= size;
        if (k == 0) return head;

        tail.next = head;

        int splitIndex = size - k;

        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < splitIndex; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;

        return curr;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head;

        // Insert clone nodes between original nodes
        while (current != null) {
            Node clone = new Node(current.val);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Wire the random pointer
        current = head;

        while (current != null) {
            Node clone = current.next;
            if (current.random != null) {
                clone.random = current.random.next;
            }
            current = clone.next;
        }

        // remove the connections between original and clone
        Node dummy = new Node(0);
        Node currentClone = dummy;
        current = head;

        while (current != null) {
            currentClone.next = current.next;
            currentClone = currentClone.next;
            current.next = currentClone.next;
            current = currentClone.next;
        }

        return dummy.next;
    }
}











class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    public MyLinkedList() {
        this.head = new Node(-1);
    }
    
    public int get(int index) {
        Node curr = head.next;

        if (curr == null) return -1;
        int i = 0;

        while (curr != null) {
            if (i == index) return curr.val;

            curr = curr.next;
            i++;
        }

        // System.out.println("get(" + index + ") : " + print());

        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head.next;
        head.next = newNode;

        // System.out.println("addAtHead(" + val + ") : " + print());
    }
    
    public void addAtTail(int val) {
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(val);
        // System.out.println("addAtTail(" + val + ") : " + print());
    }
    
    public void addAtIndex(int index, int val) {
        Node prev = head;
        Node curr = head.next;
            Node newNode = new Node(val);

        int i = 0;

        while (curr != null && i <= index) {
            if (i == index) {
                newNode.next = curr;
                prev.next = newNode;
                // System.out.println("addAtIndex(" + index + ", " + val + ") : " + print());
                return;
            } else {
                prev = curr;
                curr = curr.next;
                i++;
            }
        }

        if (i == index) {
            prev.next = newNode;
        }
        // System.out.println("addAtIndex(" + index + ", " + val + ") : " + print());
    }
    
    public void deleteAtIndex(int index) {
        Node prev = head;
        Node curr = head.next;

        int i = 0;

        while (curr != null && i <= index) {
            if (i == index) {
                prev.next = curr.next;
                // System.out.println("deleteAtIndex(" + index + ") : " + print());
                return;
            } else {
                prev = curr;
                curr = curr.next;
                i++;
            }
        }
        // System.out.println("deleteAtIndex(" + index + ") : " + print());
    }

    private String print() {
        Node curr = head.next;

        StringBuilder sb = new StringBuilder();

        while (curr != null) {
            sb.append(curr.val + ", ");
            curr = curr.next;
        }

        return sb.toString();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
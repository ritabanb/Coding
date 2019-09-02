package LinkedLists;

class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}

public class LinkedList {
    void printNode(Node head) {
        while (head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    Node deleteNode(Node head, int data) {
        Node n = head;
        if (n.data == data)
            return head.next;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}

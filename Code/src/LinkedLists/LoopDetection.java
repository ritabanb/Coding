package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {
    private Node findLoop(Node head) {
        Set<Node> uniqueNodes = new HashSet<>();
        while (head != null) {
            if (uniqueNodes.contains(head))
                return head;
            uniqueNodes.add(head);
            head = head.next;
        }
        return null;
    }

    private void printLinkedList(Node head) {
        Node n = head;
        while (n != null)
        {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1.next.next;

        LoopDetection obj = new LoopDetection();

//        obj.printLinkedList(head1);

        Node result = obj.findLoop(head1);

        System.out.println(result.data);
    }
}

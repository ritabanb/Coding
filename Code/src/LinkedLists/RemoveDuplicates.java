package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    private Node removeDuplicates(Node head) {
        Node n = head;
        Set<Integer> uniqueData = new HashSet<>();
        uniqueData.add(n.data);
        while (n.next != null) {
            if (uniqueData.contains(n.next.data))
                n.next = n.next.next;
            else {
                uniqueData.add(n.next.data);
                n = n.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        Node n = start;
        while (n != null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }

        System.out.println();

        RemoveDuplicates obj = new RemoveDuplicates();
        Node result = obj.removeDuplicates(start);

        while (result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}

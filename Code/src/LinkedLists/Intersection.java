package LinkedLists;

public class Intersection {
    private Node intersectionNode(Node head1, Node head2) {
        Node n1 = head1, n2 = head2;
        int n1Len = 0, n2Len = 0;

        while (n1 != null) {
            n1Len++;
            n1 = n1.next;
        }
        while (n2 != null) {
            n2Len++;
            n2 = n2.next;
        }
        n1 = head1;
        n2 = head2;
        while (n1Len > n2Len) {
            n1 = n1.next;
            n1Len--;
        }
        while (n2Len > n1Len) {
            n2 = n2.next;
            n2Len--;
        }

        while (n1 != null && n1.data != n2.data) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
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
        Node head1 = new Node(4);
        head1.next = new Node(0);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = new Node(5);
        head2.next = new Node(0);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(8);
        head2.next.next.next.next = new Node(4);
        head2.next.next.next.next.next = new Node(5);

        Intersection obj = new Intersection();

        obj.printLinkedList(head1);
        obj.printLinkedList(head2);

        Node result = obj.intersectionNode(head1, head2);

        obj.printLinkedList(result);
    }
}

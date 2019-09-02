package LinkedLists;

public class SumLists {
    private Node reverseSum(Node head1, Node head2) {
        int num1 = 0, num2 = 0;
        int count = 1;
        while (head1 != null) {
            num1 += (head1.data * count);
            head1 = head1.next;
            count *= 10;
        }
        count = 1;
        while (head2 != null) {
            num2 += (head2.data * count);
            head2 = head2.next;
            count *= 10;
        }
        int num = num1 + num2;
        Node head  = new Node(num % 10);
        Node n = head;
        int temp = num / 10;
        while(temp != 0) {
            n.next = new Node(temp % 10);
            temp /= 10;
            n = n.next;
        }
        return head;
    }

    private Node forwardSum(Node head1, Node head2) {
        int num1 = head1.data, num2 = head2.data;
        head1 = head1.next;
        head2 = head2.next;
        while (head1 != null) {
            num1 = (num1 * 10) + head1.data;
            head1 = head1.next;
        }
        while (head2 != null) {
            num2 = (num2 * 10) + head2.data;
            head2 = head2.next;
        }
        int num = num1 + num2;
        Node n  = new Node(num % 10);
        int temp = num / 10;
        Node newNode = null;
        while(temp != 0) {
            newNode = new Node(temp % 10);
            newNode.next = n;
            n = newNode;
            temp /= 10;
        }
        return newNode;
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
        Node head1 = new Node(7);
        head1.next = new Node(1);
        head1.next.next = new Node(6);

        Node head2 = new Node(5);
        head2.next = new Node(9);
        head2.next.next = new Node(2);

        SumLists obj = new SumLists();

        obj.printLinkedList(head1);
        obj.printLinkedList(head2);

        Node result = obj.reverseSum(head1, head2);

        obj.printLinkedList(result);

        System.out.println();

        head1 = new Node(6);
        head1.next = new Node(1);
        head1.next.next = new Node(7);

        head2 = new Node(2);
        head2.next = new Node(9);
        head2.next.next = new Node(5);


        obj.printLinkedList(head1);
        obj.printLinkedList(head2);

        result = obj.forwardSum(head1, head2);

        obj.printLinkedList(result);
    }

}

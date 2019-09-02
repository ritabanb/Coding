package LinkedLists;

public class Partition {
    private Node partition(Node head, int partition) {
        Node left = null, right = null, leftHead = null, rightHead = null;
        while(head != null) {
            if (head.data < partition) {
                if (left == null) {
                    left = new Node(head.data);
                    leftHead = left;
                }
                else {
                    left.next = new Node(head.data);
                    left = left.next;
                }
            }
            else {
                if (right == null) {
                    right = new Node(head.data);
                    rightHead = right;
                }
                else {
                    right.next = new Node(head.data);
                    right = right.next;
                }
            }
            head = head.next;
        }
        left.next = rightHead;
        return leftHead;
    }


    public static void main(String[] args) {
        Node start = new Node(3);
        start.next = new Node(5);
        start.next.next = new Node(8);
        start.next.next.next = new Node(5);
        start.next.next.next.next = new Node(10);
        start.next.next.next.next.next = new Node(2);
        start.next.next.next.next.next.next = new Node(1);

        Node n = start;
        while (n != null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }

        System.out.println();

        Partition obj = new Partition();
        Node result = obj.partition(start, 5);

        while (result != null)
        {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}

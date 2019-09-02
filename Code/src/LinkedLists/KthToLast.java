package LinkedLists;

public class KthToLast {
    private Node returnKthToLast(Node head, int k) {
        Node n = head;
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        int kLast = count - k;
        n = head;
        count = 0;
        while (n != null) {
            if (count == kLast)
                return n;
            count++;
            n = n.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        start.next.next.next.next.next = new Node(6);
        start.next.next.next.next.next.next = new Node(7);

        Node n = start;
        while (n != null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }

        System.out.println();

        KthToLast obj = new KthToLast();
        Node result = obj.returnKthToLast(start, 3);
        System.out.println(result.data);
    }
}

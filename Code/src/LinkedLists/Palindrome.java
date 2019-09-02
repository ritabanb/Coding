package LinkedLists;

import java.util.Stack;

public class Palindrome {
    private boolean isPalindrome(Node head) {
        Stack<Integer> numberStore = new Stack<>();
        Node n = head;
        while (n != null) {
            numberStore.push(n.data);
            n = n.next;
        }

        n = head;
        while (n != null) {
            if (numberStore.pop() != n.data)
                return false;
            n = n.next;
        }
        return true;
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
        Node head1 = new Node(6);
        head1.next = new Node(1);
        head1.next.next = new Node(6);

        Palindrome obj = new Palindrome();

        obj.printLinkedList(head1);

        System.out.println(obj.isPalindrome(head1));
    }
}

package LinkedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null)
            current.next = l1;
        else if (l2 != null)
            current.next = l2;

        return head;
    }

    private void printLinkedList(ListNode head) {
        ListNode n = head;
        while (n != null)
        {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedList obj = new MergeTwoSortedList();
        ListNode result = obj.mergeTwoLists(l1, l2);
        obj.printLinkedList(l1);
        obj.printLinkedList(l2);
        obj.printLinkedList(result);
    }
}

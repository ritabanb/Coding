package LinkedLists;

public class DeleteMiddleNode {
    private void deleteMiddleNode(Node middle) {
        Node n = middle.next;
        middle.data = n.data;
        middle.next = n.next;
    }
}

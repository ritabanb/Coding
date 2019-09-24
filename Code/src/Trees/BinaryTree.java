package Trees;

class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }
}

public class BinaryTree<T> {
    void inOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " -> ");
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.value + " -> ");
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            System.out.print(node.value + " -> ");

        }
    }
}

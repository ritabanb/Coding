package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeTree {
    private String serialize_rec(TreeNode node, String str) {
        if (node == null)
            str += null + ",";
        else {
            str += node.value + ",";
            str = serialize_rec(node.left, str);
            str = serialize_rec(node.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize_rec(root, "");
    }

    private TreeNode dserialize_rec(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(data.get(0)));
        data.remove(0);
        node.left = dserialize_rec(data);
        node.right = dserialize_rec(data);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList = new ArrayList<>(Arrays.asList(data.split(",")));
        return dserialize_rec(dataList);
    }

    public static void main(String[] args) {
        SerializeDeserializeTree obj = new SerializeDeserializeTree();
        TreeNode<Integer> root = obj.deserialize("1,2,3,null,null,4,5");
        System.out.println(obj.serialize(root));
    }
}

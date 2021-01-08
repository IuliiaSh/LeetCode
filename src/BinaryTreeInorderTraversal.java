import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        traverseInorder(result, root);
        return result;
    }

    private void traverseInorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            traverseInorder(result, root.left);
            result.add(root.val);
            traverseInorder(result, root.right);
        }
    }
}

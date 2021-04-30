import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null) return result;
        
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        current.add(root);
        Queue<TreeNode> next;
        TreeNode node = new TreeNode();
        while (!current.isEmpty()) {
            next = new LinkedList<TreeNode>();
            while (!current.isEmpty()) {
                node = current.remove();
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(node.val);
            current = new LinkedList<TreeNode>(next);
        }
        return result;
    }
}

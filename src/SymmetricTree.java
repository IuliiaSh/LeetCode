import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftSubtree = new LinkedList();
        leftSubtree.offer(root);
        Queue<TreeNode> rightSubtree = new LinkedList();
        rightSubtree.offer(root);
        TreeNode leftNode;
        TreeNode rightNode;
        while (!leftSubtree.isEmpty() && !rightSubtree.isEmpty()) {
            leftNode = leftSubtree.remove();
            rightNode = rightSubtree.remove();

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            if (leftNode.val != rightNode.val) {
                return false;
            }

            leftSubtree.offer(leftNode.left);
            leftSubtree.offer(leftNode.right);
            rightSubtree.offer(rightNode.right);
            rightSubtree.offer(rightNode.left);
        }

        if (!leftSubtree.isEmpty() || !rightSubtree.isEmpty()) {
            return false;
        }
        return true;
    }
}

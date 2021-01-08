import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        
        Queue<TreeNode> previousLevel = new LinkedList<TreeNode>();
        previousLevel.add(root);
        Queue<TreeNode> currentLevel;
        TreeNode currentNode;
        while (!previousLevel.isEmpty()) {
            result++;
            currentLevel = new LinkedList<TreeNode>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                if (currentNode.left != null) currentLevel.add(currentNode.left);
                if (currentNode.right != null) currentLevel.add(currentNode.right);
            }
            previousLevel = new LinkedList<TreeNode>(currentLevel);
        }
        return result;
    }
}

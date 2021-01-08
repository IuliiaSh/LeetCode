import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> previousLevel = new LinkedList<TreeNode>();
        previousLevel.add(root);
        Queue<TreeNode> currentLevel;
        TreeNode currentNode;
        List<Integer> previousResult;
        while (!previousLevel.isEmpty()) {
            currentLevel = new LinkedList<TreeNode>();
            previousResult = new ArrayList<Integer>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                previousResult.add(currentNode.val);
                if (currentNode.left != null) currentLevel.add(currentNode.left);
                if (currentNode.right != null) currentLevel.add(currentNode.right);
            }
            result.add(previousResult);
            previousLevel = new LinkedList<TreeNode>(currentLevel);
        }
        return result;
    }
}

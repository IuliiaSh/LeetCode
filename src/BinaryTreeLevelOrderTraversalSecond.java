import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalSecond {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> previousLevel = new LinkedList<TreeNode>();
        previousLevel.add(root);
        Queue<TreeNode> currentLevel;
        TreeNode currentNode;
        List<Integer> currentResult;
        while (!previousLevel.isEmpty()) {
            currentResult = new ArrayList<Integer>();
            currentLevel = new LinkedList<TreeNode>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                currentResult.add(currentNode.val);
                if (currentNode.left != null) currentLevel.add(currentNode.left);
                if (currentNode.right != null) currentLevel.add(currentNode.right);
            }
            result.add(currentResult);
            previousLevel = currentLevel;
        }
        Collections.reverse(result);
        return result;
    }
}

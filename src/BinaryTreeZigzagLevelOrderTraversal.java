import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        int i = 0;
        Queue<TreeNode> previousLevel = new LinkedList<TreeNode>();
        previousLevel.add(root);
        Queue<TreeNode> currentLevel;
        TreeNode currentNode;
        List<Integer> previousResult;
        while (!previousLevel.isEmpty()) {
            i++;
            currentLevel = new LinkedList<TreeNode>();
            previousResult = new ArrayList<Integer>();
            while (!previousLevel.isEmpty()) {
                currentNode = previousLevel.remove();
                previousResult.add(currentNode.val);
                if (currentNode.left != null) currentLevel.add(currentNode.left);
                if (currentNode.right != null) currentLevel.add(currentNode.right);
            }
            if (i % 2 == 0) Collections.reverse(previousResult);
            result.add(previousResult);
            previousLevel = new LinkedList<TreeNode>(currentLevel);
        }
        return result;
    }
}

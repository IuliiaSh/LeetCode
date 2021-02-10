import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        int currentSum = root.val;
        List<Integer> currentResult = new ArrayList<Integer>();
        currentResult.add(root.val);
        findPathSum(root, targetSum, currentSum, currentResult, result);
        return result;
    }
    
    private void findPathSum(TreeNode node, int targetSum, int currentSum,
                             List<Integer> currentResult, List<List<Integer>> result) {
        if (node.left == null && node.right == null && currentSum == targetSum) {
            result.add(new ArrayList<Integer>(currentResult));
        }
         
        if (node.left != null) {
            currentResult.add(node.left.val);
            currentSum = currentSum + node.left.val;
            findPathSum(node.left, targetSum, currentSum, currentResult, result);
            currentResult.remove(currentResult.size() - 1);
            currentSum = currentSum - node.left.val;
        }
        
        if (node.right != null) {
            currentResult.add(node.right.val);
            currentSum = currentSum + node.right.val;
            findPathSum(node.right, targetSum, currentSum, currentResult, result);
            currentResult.remove(currentResult.size() - 1);
            currentSum = currentSum - node.right.val;
        }
    } 
}

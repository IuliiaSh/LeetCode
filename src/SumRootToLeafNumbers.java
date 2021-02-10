public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int[] result = {0};
        StringBuilder currentNumber = new StringBuilder();
        currentNumber.append(root.val);
        findPathSum(root, currentNumber, result);
        return result[0];
    }
    
    private void findPathSum(TreeNode node, StringBuilder currentNumber, int[] result) {
        if (node.left == null && node.right == null) {
        	result[0] = result[0] + Integer.parseInt(currentNumber.toString());
        }
         
        if (node.left != null) {
            currentNumber.append(node.left.val);
            findPathSum(node.left, currentNumber, result);
            currentNumber.deleteCharAt(currentNumber.length() - 1);
        }
        
        if (node.right != null) {
            currentNumber.append(node.right.val);
            findPathSum(node.right, currentNumber, result);
            currentNumber.deleteCharAt(currentNumber.length() - 1);
        }
    } 
}

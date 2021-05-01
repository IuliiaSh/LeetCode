public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        return countNodesRecursively(root);
    }
    
    private int countNodesRecursively(TreeNode root) {
        if (root == null) return 0;
        
        TreeNode current = root;
        int leftHeight = 0;
        while (current != null) {
            leftHeight++;
            current = current.left;
        }
        
        current = root;
        int rightHeight = 0;
        while (current != null) {
            rightHeight++;
            current = current.right;
        }
        
        int result = 0;
        if (leftHeight == rightHeight) {
            current = root;
            int currentCount = 1;
            while (root != null) {
                result = result + currentCount;
                currentCount = 2 * currentCount;
                root = root.left;
            }
            
        } else {
            result = 1 + countNodesRecursively(root.left) + countNodesRecursively(root.right);
        }
        return result;
    }
}


public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) return false;
        return true;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getHeight(root.left);
        int rigthHeight = getHeight(root.right);
        if (leftHeight == -1 || rigthHeight == -1 || Math.abs(leftHeight - rigthHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rigthHeight);
    }
}

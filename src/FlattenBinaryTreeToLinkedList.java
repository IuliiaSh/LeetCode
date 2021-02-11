public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode lastAdded = new TreeNode(root.val);
        TreeNode newRoot = lastAdded;
        addPreOrder(lastAdded, root);
        root.left = null;
        root.right = newRoot.right;
    }
    
    private TreeNode addPreOrder(TreeNode lastAdded, TreeNode node) {        
        if (node.left != null) {
        	lastAdded.right = new TreeNode(node.left.val);
        	lastAdded = addPreOrder(lastAdded.right, node.left);
        } 
        
        if (node.right != null) {
        	lastAdded.right = new TreeNode(node.right.val);
        	lastAdded = addPreOrder(lastAdded.right, node.right);
        }
        return lastAdded;
    }
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        TreeNode root = buildTree(preorder, 0, inorder, 0, inorder.length - 1);
        return root;
    }

	private TreeNode buildTree(int[] preorder, int preorderStartIndex, 
			int[] inorder, int inorderStartIndex, int inorderEndIndex) {
		int value = preorder[preorderStartIndex];
		TreeNode root = new TreeNode(value);
		
		int inorderIndex = inorderStartIndex;
		while (inorder[inorderIndex] != value) {
			inorderIndex++;
		}
		
		int leftSize = inorderIndex - inorderStartIndex;
		if (leftSize > 0) {
			int leftInorderStartIndex = inorderStartIndex;
			int leftInorderEndIndex = inorderIndex - 1;
			int leftPreorderStartIndex = preorderStartIndex + 1;
			root.left = buildTree(preorder, leftPreorderStartIndex, 
					inorder, leftInorderStartIndex, leftInorderEndIndex);
		}
		
		int rightSize = inorderEndIndex - inorderIndex;
		if (rightSize > 0) {
			int rightInorderStartIndex = inorderIndex + 1;
			int rightInorderEndIndex = inorderEndIndex;
			int rightPreorderStartIndex = preorderStartIndex + 1 + leftSize;
			root.right = buildTree(preorder, rightPreorderStartIndex, 
					inorder, rightInorderStartIndex, rightInorderEndIndex);
		}
		return root;
	}
}

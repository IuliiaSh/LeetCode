public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) return null;

        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }
	
	private TreeNode buildTree(int[] inorder, int inorderStartIndex, int inorderEndIndex,
			int[] postorder, int postorderStartIndex, int postorderEndIndex) {
		int value = postorder[postorderEndIndex];
		TreeNode root = new TreeNode(value);
		
		int inorderIndex = inorderStartIndex;
		while (inorder[inorderIndex] != value) {
			inorderIndex++;
		}
		
		int leftSize = inorderIndex - inorderStartIndex;
		if (leftSize > 0) {
			int leftInorderStartIndex = inorderStartIndex;
			int leftInorderEndIndex = inorderIndex - 1;
			int leftPostorderStartIndex = postorderStartIndex;
			int leftPostorderEndIndex = postorderStartIndex + leftSize - 1;
			root.left = buildTree(inorder, leftInorderStartIndex, leftInorderEndIndex,
					postorder, leftPostorderStartIndex, leftPostorderEndIndex);
		}
		
		int rightSize = inorderEndIndex - inorderIndex;
		if (rightSize > 0) {
			int rightInorderStartIndex = inorderIndex + 1;
			int rightInorderEndIndex = inorderEndIndex;
			int rightPostorderStartIndex = postorderEndIndex - rightSize;
			int rightPostorderEndIndex = postorderEndIndex - 1;
			root.right = buildTree(inorder, rightInorderStartIndex, rightInorderEndIndex,
					postorder, rightPostorderStartIndex, rightPostorderEndIndex);
		}
		return root;
	}
}

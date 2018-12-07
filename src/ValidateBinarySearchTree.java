public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    private boolean checkBST(TreeNode root, TreeNode lastSmaller, TreeNode lastBigger) {
        if (root == null) {
            return true;
        }

        if (lastSmaller != null && root.val <= lastSmaller.val ||
                lastBigger != null && root.val >= lastBigger.val) {
            return false;
        }
        return checkBST(root.left, lastSmaller, root) && checkBST(root.right, root, lastBigger);
    }
}

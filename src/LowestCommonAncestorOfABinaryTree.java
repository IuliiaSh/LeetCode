import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = new Stack<TreeNode>();
        contains(root, p, pPath);
        Stack<TreeNode> qPath = new Stack<TreeNode>();
        contains(root, q, qPath);

        TreeNode result = root;
        while (!pPath.isEmpty() && !qPath.isEmpty() && pPath.peek() == qPath.peek()) {
            result = pPath.peek();
            pPath.pop();
            qPath.pop();
        }
        return result;
    }
    
    private boolean contains(TreeNode current, TreeNode target, Stack<TreeNode> path) {
        if (current == target) {
            return true;
        }
        
        boolean result = false;
        if (current.left != null && contains(current.left, target, path)) {
            path.push(current.left);
            result = true;
        } else if (current.right != null && contains(current.right, target, path)) {
            path.push(current.right);
            result = true;
        }
        return result;
    }
}

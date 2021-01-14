import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        visitNode(root, result);
        return result;
    }
    
    private void visitNode(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        visitNode(root.left, result);
        visitNode(root.right, result);
        result.add(root.val);
    }
}

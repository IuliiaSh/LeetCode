import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        visitNode(root, result);
        return result;
    }
    
    private void visitNode(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        result.add(root.val);
        visitNode(root.left, result);
        visitNode(root.right, result);
    }
}

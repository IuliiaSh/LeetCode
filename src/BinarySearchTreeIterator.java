import java.util.Stack;

public class BinarySearchTreeIterator {
	Stack<TreeNode> stack;
	boolean isGoLeft;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        stack.push(root);
        isGoLeft = true;
    }
    
    public int next() {
        while (isGoLeft && stack.peek().left != null) {
            stack.push(stack.peek().left);
        }
        isGoLeft = false;
        
        TreeNode current = stack.pop();
        if (current.right != null) {
            stack.push(current.right);
            isGoLeft = true;
        }
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

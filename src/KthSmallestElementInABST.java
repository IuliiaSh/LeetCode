public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
        int[] currentSum = {1};
        return traverse(root, currentSum, k).val;
    }
    
    private TreeNode traverse(TreeNode node, int[] currentSum, int neededSum) {
    	TreeNode result = null;
        if (node.left != null) {
        	result = traverse(node.left, currentSum, neededSum);
            if (result != null) {
            	return result;
            }
            
            currentSum[0]++;
        }
        
        if (currentSum[0] == neededSum) {
        	return node;
        }
        
        if (node.right != null) {
        	currentSum[0]++;
        	
        	result = traverse(node.right, currentSum, neededSum); 
        }
        return result;       
    }
}

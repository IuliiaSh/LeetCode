public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursive(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBSTRecursive(int[] nums, int start, int end) { 
        if (start > end) return null;
        
        int middle = (end + start) / 2;
        TreeNode result = new TreeNode(nums[middle]);
        result.left = sortedArrayToBSTRecursive(nums, start, middle - 1);
        result.right = sortedArrayToBSTRecursive(nums, middle + 1, end);
        return result;
    }
}

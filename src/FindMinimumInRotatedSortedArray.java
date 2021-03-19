public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        return searchRecursive(nums, 0, nums.length - 1);
    }

    private int searchRecursive(int[] nums, int startIndex,int endIndex) {
        if (startIndex == endIndex) return nums[startIndex];
        
    	int middleIndex = (startIndex + endIndex)/2;
		int leftResult = nums[startIndex];
		if (checkRotated(nums, startIndex, middleIndex)) {
	        leftResult = searchRecursive(nums, startIndex, middleIndex);
		}
	    
	    int rightResult = nums[middleIndex + 1];
		if (checkRotated(nums, middleIndex + 1, endIndex)) {
			rightResult = searchRecursive(nums, middleIndex + 1, endIndex);
		}
        return Math.min(rightResult, leftResult);
    }
    
    private boolean checkRotated(int[] nums, int startIndex, int endIndex) {
        if (nums[startIndex] >= nums[endIndex]) return true;
        return false;
    }
}

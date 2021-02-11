public class SearchInRotatedSortedArrayTwo {
	public boolean search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        return searchRecursive(nums, target, startIndex, endIndex);
    }
    
    private boolean searchRecursive(int[] nums, int target, int startIndex,int endIndex) {
    	int middleIndex = (startIndex + endIndex)/2;
		int middle = nums[middleIndex];
		if (target == middle) return true;
		
		boolean leftResult = false;
		boolean isGoLeft = checkGo(nums, target, startIndex, middleIndex);
		if (isGoLeft) {
	        leftResult = searchRecursive(nums, target, startIndex, middleIndex - 1);
		}
	    
	    boolean rightResult = false;
	    boolean isGoRight = checkGo(nums, target, middleIndex, endIndex);
		if (isGoRight) {
			rightResult = searchRecursive(nums, target, middleIndex + 1, endIndex);
		}
        return leftResult || rightResult;
    }
    
    private boolean checkGo(int[] nums, int target, int startIndex, int endIndex) {
    	if (startIndex == endIndex) return false;
    	
        int start = nums[startIndex];
        int end = nums[endIndex];
        boolean isRotated = checkRotated(nums, startIndex, endIndex);
	    if (isRotated) {
	        if (target >= start || target <= end) {
	        	return true;
	        }
	    } else {
	        if (target >= start && target <= end) {
	        	return true;
	        }
	    }
	    return false;
    }

    private boolean checkRotated(int[] nums, int startIndex, int endIndex) {
        if (nums[startIndex] >= nums[endIndex]) return true;
        return false;
    }
}

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
    	if (target > nums[nums.length - 1]) return nums.length;
    	
        int startIndex = 0;
        int endIndex = nums.length - 1;
        return searchInsertPositionRecursive(nums, target, startIndex, endIndex);
    }
    
    private int searchInsertPositionRecursive(int[] nums, 
    		int target, int startIndex,int endIndex) {
		int middleIndex = (startIndex + endIndex)/2;
		int current = nums[middleIndex];
		if (current == target) {
			return middleIndex;
		} else if (current > target) {
			if (endIndex == middleIndex) return middleIndex;
			endIndex = middleIndex;
		} else {
			if (startIndex == middleIndex) return middleIndex + 1;
			startIndex = middleIndex;
		}
		return searchInsertPositionRecursive(nums, target, startIndex, endIndex);
    }
}

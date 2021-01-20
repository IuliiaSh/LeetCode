public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] { -1, -1 };
        
        int start = 0;
        int end = nums.length - 1;
        return searchRange(nums, start, end, target);
    }
    
    private int[] searchRange(int[] nums, int start, int end, int target) {
    	if (start > end) return new int[] {-1, -1};
        if (start == end) {
            if (nums[start] == target) {
                return new int[] {start, end};
            } else {
                return new int[] {-1, -1};
            }
        }
        
        int middle = (start + end)/2;
        if (nums[middle] == target) {
        	start = searchStart(nums, start, middle);
        	end = searchEnd(nums, middle, end);
        	return new int[] {start, end};
        } else if (nums[middle] > target) {
            return searchRange(nums, start, middle - 1, target);
        } else {
            return searchRange(nums, middle + 1, end, target);
        }
    }
    
    private int searchStart(int[] nums, int start, int end) {
        if (start == end) return end;
        
        int middle = (start + end)/2;
        if (nums[middle] == nums[end]) {
        	return searchStart(nums, start, middle);
        } else {
            return searchStart(nums, middle + 1, end);
        }
    }
    
    private int searchEnd(int[] nums, int start, int end) {
        if (start == end) return start;
        
        int middle = (start + end)/2 + 1;
        if (nums[middle] == nums[start]) {
        	return searchEnd(nums, middle, end);
        } else {
            return searchEnd(nums, start, middle - 1);
        }
    }
}

public class RemoveDuplicatesFromSortedArrayTwo {
	public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int currentCount = 1;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
            	currentCount++;
            } else {
            	currentCount = Math.min(currentCount, 2);
                for (int k = 0; k < currentCount; k++) {
                	nums[j] = nums[i];
                	j++;
                }
            	currentCount = 1;
            }
        }
        
        if (nums[nums.length - 1] == nums[nums.length - 2]) {
        	nums[j] = nums[nums.length - 2];
            j++;
            nums[j] = nums[nums.length - 1];
            j++;
        } else {
        	nums[j] = nums[nums.length - 1];
        	j++;
        }
        return j;
    }
}

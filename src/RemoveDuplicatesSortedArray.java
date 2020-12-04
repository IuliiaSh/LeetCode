public class RemoveDuplicatesSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        
        int currentWrite = 1;
        for (int currentRead = 1; currentRead < nums.length; currentRead++) {
            if (nums[currentRead - 1] != nums[currentRead]) {
                nums[currentWrite] = nums[currentRead];
                currentWrite++;
            }
        }
        return currentWrite;
    }
}

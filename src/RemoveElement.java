public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        
        int currentReader = 0;
        int currentWriter = 0;
        for (; currentReader < nums.length; currentReader++) {
            if (nums[currentReader] != val) {
                nums[currentWriter] = nums[currentReader];
                currentWriter++;
            }
        }
        return currentWriter;
    }
}

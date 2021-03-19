public class RotateArray {
	public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[incrementIndex(i, nums, k)] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
    
    private int incrementIndex(int index, int[] nums, int k) {
        return (index + k) % nums.length;
    }
}

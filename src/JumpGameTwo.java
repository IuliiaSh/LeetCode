public class JumpGameTwo {
    public int jump(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        jumpRecursively(nums, result, index);
        return result[nums.length - 1];
    }
    
    private void jumpRecursively(int[] nums, int[] result, int index) {
        if (index >= nums.length) return;
        
        for (int i = index + 1; i <= index + nums[index] && i < nums.length; i++) {
            if (result[i] == 0 || result[i] > result[index] + 1) {
                result[i] = result[index] + 1;
                jumpRecursively(nums, result, i);
            }
        }
    }
}

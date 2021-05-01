public class HouseRobberTwo {
	public int rob(int[] nums) {
        return Math.max(robRecursively(nums, 1, new int[nums.length], false),
                        nums[0] + robRecursively(nums, 2, new int[nums.length], true));
    }
    
    private int robRecursively(int[] nums, int index, int[] memo, boolean isFirstIncluded) {
        if (isFirstIncluded && index == nums.length - 1) return 0;
        if (index >= nums.length) return 0;
        
        if (memo[index] != 0) return memo[index];
        
        int withResult;
        if (nums[index] == 0) {
            withResult = 0;
        } else {
            withResult = nums[index] + robRecursively(nums, index + 2, memo, isFirstIncluded);
        }
        
        int withoutResult = robRecursively(nums, index + 1, memo, isFirstIncluded);
        memo[index] = Math.max(withResult, withoutResult);
        return memo[index];
    }
}

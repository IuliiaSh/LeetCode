public class HouseRobber {
	public int rob(int[] nums) {
        return robRecursively(nums, 0, new int[nums.length]);
    }
    
    private int robRecursively(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        
        if (memo[index] != 0) return memo[index];
        
        int withResult;
        if (nums[index] == 0) {
            withResult = 0;
        } else {
            withResult = nums[index] + robRecursively(nums, index + 2, memo);
        }
        
        int withoutResult = robRecursively(nums, index + 1, memo);
        memo[index] = Math.max(withResult, withoutResult);
        return memo[index];
    }
}

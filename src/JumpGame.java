public class JumpGame {
	public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        
        int maxMove = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxMove == 0) return false;
            
            maxMove--;
            maxMove = Math.max(maxMove, nums[i]);
        }
        return true;
    }
}

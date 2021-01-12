public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int leftMax = nums[0];
		int leftBorderMax = leftMax;
		int rightMax;
		int middleMax;
		for (int i = 1; i < nums.length; i++) {
			rightMax = nums[i];
			middleMax = leftBorderMax + rightMax;
			leftMax = Math.max(Math.max(leftMax, rightMax), middleMax);
			leftBorderMax = Math.max(rightMax, leftBorderMax + rightMax);
		}
		return leftMax;
	}
}

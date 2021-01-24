import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[2];
        int middleIndex;
        int rightIndex;
        int sum;
        for (int leftIndex = 0; leftIndex < nums.length - 2; leftIndex++) {
        	middleIndex = leftIndex + 1;
        	rightIndex = nums.length - 1;
        	while (middleIndex < rightIndex) {
        		sum = nums[leftIndex] + nums[middleIndex] + nums[rightIndex];
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
                    
        		if (sum < target) {
        			middleIndex++;
        		} else if (sum > target) {
        			rightIndex--;
        		} else {
        			return target;
        		}
        	}
        }
        return result;
    }
}

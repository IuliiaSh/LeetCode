import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	if (nums.length < 3) return new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        Set<List<Integer>> setResult = new HashSet<List<Integer>>();
        List<Integer> currentResult;
        int middleIndex;
        int rightIndex;
        int sum;
        for (int leftIndex = 0; leftIndex < nums.length - 2; leftIndex++) {
        	middleIndex = leftIndex + 1;
        	rightIndex = nums.length - 1;
        	while (middleIndex < rightIndex) {
        		sum = nums[leftIndex] + nums[middleIndex] + nums[rightIndex];
        		if (sum < 0) {
        			middleIndex++;
        		} else if (sum > 0) {
        			rightIndex--;
        		} else {
        			currentResult = new ArrayList<Integer>();
        			currentResult.add(nums[leftIndex]);
        			currentResult.add(nums[middleIndex]);
        			currentResult.add(nums[rightIndex]);
        			setResult.add(currentResult);
        			middleIndex++;
        		}
        	}
        }
        return new ArrayList<List<Integer>>(setResult);
    }      
}

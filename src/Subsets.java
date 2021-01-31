import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        boolean[] isUsed = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentSubset = new ArrayList<Integer>();
        int currentIndex = 0;
        getSubsets(nums, isUsed, result, currentSubset, currentIndex);
        return result;
    }
    
    private void getSubsets(int[] nums, boolean[] isUsed, List<List<Integer>> result, 
    		List<Integer> currentSubset, int currentIndex) {
        result.add(new ArrayList<Integer>(currentSubset));
        
        for (int i = currentIndex; i < nums.length; i++) {
            if (!isUsed[i]) {
                currentSubset.add(nums[i]);
                isUsed[i] = true;
                getSubsets(nums, isUsed, result, currentSubset, i + 1);
                currentSubset.remove(currentSubset.size() - 1);
                isUsed[i] = false;
            }
        }
    }
}

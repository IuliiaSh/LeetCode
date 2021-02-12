import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsTwo {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> currentSubset = new ArrayList<Integer>();
        int currentIndex = 0;
        getSubsets(nums, isUsed, result, currentSubset, currentIndex);
        List<List<Integer>> listResult = new ArrayList<List<Integer>>();
        listResult.addAll(result);
        return listResult;
    }
    
    private void getSubsets(int[] nums, boolean[] isUsed, Set<List<Integer>> result, 
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

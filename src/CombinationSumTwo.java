import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumTwo {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> result = new HashSet<List<Integer>>();
	    List<Integer> currentResult = new ArrayList<Integer>();
	    int currentStartIndex = 0;
	    combinationSum(candidates, target, result, currentResult, currentStartIndex);
	    return new ArrayList<List<Integer>>(result);
	}
	
	private void combinationSum(int[] candidates, int target,
			Set<List<Integer>> result, List<Integer> currentResult, int currentStartIndex) {
	    if (target < 0) return;
	    if (target == 0) {
	    	List<Integer> possibleResult = new ArrayList<Integer>(currentResult);
	    	Collections.sort(possibleResult);
	        result.add(new ArrayList<Integer>(possibleResult));
	    }
	    
	    for (int i = currentStartIndex; i < candidates.length; i++) {
	        currentResult.add(candidates[i]);
	        combinationSum(candidates, target - candidates[i], result, currentResult, i + 1);
	        currentResult.remove(currentResult.size() - 1);
	    }
	}
}
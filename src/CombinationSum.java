import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentResult = new ArrayList<Integer>();
        int currentStartIndex = 0;
        combinationSum(candidates, target, result, currentResult, currentStartIndex);
        return result;
    }
    
    private void combinationSum(int[] candidates, int target,
                                List<List<Integer>> result, List<Integer> currentResult, int currentStartIndex) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<Integer>(currentResult));
        }
        
        for (int i = currentStartIndex; i < candidates.length; i++) {
            currentResult.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], result, currentResult, i);
            currentResult.remove(currentResult.size() - 1);
        }
    }
}

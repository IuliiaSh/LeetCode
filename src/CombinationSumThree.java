import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentResult = new ArrayList<Integer>();
        int nextNumber = 1;
        combinationSum3Recursive(k, n, nextNumber, currentResult, result);
        return result;
    }
    
    private void combinationSum3Recursive(int k, int n, int nextNumber,
        List<Integer> currentResult, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<Integer>(currentResult));
            return;
        }
        if (k == 0 || n == 0) return;
        
        for (int i = nextNumber; i <= 9; i++) {
            currentResult.add(i);
            combinationSum3Recursive(k - 1, n - i, i + 1, currentResult, result);
            currentResult.remove(currentResult.size() - 1);
        }
    }
}

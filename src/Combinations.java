import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentResult = new ArrayList<Integer>();
        int currentNumber = 1; 
        findCombinations(n, k, currentNumber, currentResult, result);
        return result;
    }
    
    private void findCombinations(int n, int k, int currentNumber,
                                  List<Integer> currentResult, List<List<Integer>> result) {
        if (currentResult.size() == k) {
            result.add(new ArrayList<Integer>(currentResult));
            return;
        }
        if (currentNumber > n - (k - currentResult.size() - 1)) return;
        
        findCombinations(n, k, currentNumber + 1, currentResult, result);

        currentResult.add(currentNumber);
        findCombinations(n, k, currentNumber + 1, currentResult, result);
        currentResult.remove(currentResult.size() - 1);
    }
}
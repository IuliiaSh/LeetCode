import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> currentResult = new ArrayList();
        boolean[] isUsed = new boolean[nums.length];
        findAllPermutations(result, currentResult, nums, isUsed);
        return result;
    }

    private void findAllPermutations(List<List<Integer>> result, List<Integer> currentResult,
                                     int[] nums, boolean[] isUsed) {
        if (currentResult.size() == nums.length) {
            result.add(new ArrayList(currentResult));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!isUsed[i]) {
                    isUsed[i] = true;
                    currentResult.add(nums[i]);
                    findAllPermutations(result, currentResult, nums, isUsed);
                    isUsed[i] = false;
                    currentResult.remove(currentResult.size() - 1);
                }
            }
        }
    }
}

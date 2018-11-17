import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueToIndexMap = new HashMap();
        int complement;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (valueToIndexMap.containsKey(complement)) {
                return new int[] { valueToIndexMap.get(complement), i };
            } else {
                valueToIndexMap.put(nums[i], i);
            }
        }

        return new int[] { 0, 0 };
    }
}

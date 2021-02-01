import java.util.HashMap;
import java.util.Map;

public class SingleNumberThree {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> numberCounts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	int count = numberCounts.containsKey(nums[i]) ? numberCounts.get(nums[i]) : 0;
        	numberCounts.put(nums[i], count + 1);
        }
        
        int[] result = new int[2];
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
        	if (entry.getValue() == 1) {
                if (result[0] == 0) {
                    result[0] = entry.getKey();
                } else {
                    result[1] = entry.getKey();
                    return result;
                }
        	}
        }
        return result;
    }
}

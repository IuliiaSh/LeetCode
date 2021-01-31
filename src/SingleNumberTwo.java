import java.util.HashMap;
import java.util.Map;

public class SingleNumberTwo {
	public int singleNumber(int[] nums) {
        Map<Integer, Integer> numberCounts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	int count = numberCounts.containsKey(nums[i]) ? numberCounts.get(nums[i]) : 0;
        	numberCounts.put(nums[i], count + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
        	if (entry.getValue() == 1) {
        		return entry.getKey();
        	}
        }
        return -1;
    }
}

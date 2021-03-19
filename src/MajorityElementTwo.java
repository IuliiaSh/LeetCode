import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementTwo {
	public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) result.add(entry.getKey());
        }
        return result;
    }
}

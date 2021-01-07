import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4) return result;
        
        Map<Integer, Set<List<Integer>>> twoSums = new HashMap<Integer, Set<List<Integer>>>();  
        int currentSum;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
        		currentSum = nums[i] + nums[j];
        		List<Integer> currentList = new ArrayList<Integer>();
        		currentList.add(i); 
        		currentList.add(j);
        		Collections.sort(currentList);
        		if (twoSums.containsKey(currentSum)) {
        			Set<List<Integer>> previousSets = twoSums.get(currentSum);
        			if (!previousSets.contains(currentList)) {
        				previousSets.add(currentList);
        			}
        		} else {
        			Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
        			currentSet.add(currentList);
        			twoSums.put(currentSum, currentSet);
        		}
        	}
        }
        
        Set<List<Integer>> setResult = new HashSet<List<Integer>>();
        int complementSum;
        for (Map.Entry<Integer, Set<List<Integer>>> entry : twoSums.entrySet()) {
        	currentSum = entry.getKey();
        	complementSum = target - currentSum;
        	Set<List<Integer>> currentSet = entry.getValue();
        	if (twoSums.containsKey(complementSum)) {
        		Set<List<Integer>> complementSet = twoSums.get(complementSum);
        		for (List<Integer> currentList : currentSet) {
        			for (List<Integer> complementList : complementSet) {
        				boolean hasIntersection = checkIntersection(currentList, complementList);
        				if (!hasIntersection) {
        					List<Integer> unitedIndexSet = unite(currentList, complementList);
        					List<Integer> unitedValueSet = new ArrayList<Integer>();
        					for (int i = 0; i < unitedIndexSet.size(); i++) {
        						unitedValueSet.add(nums[unitedIndexSet.get(i)]);
        					}
	                        Collections.sort(unitedValueSet);
	                        setResult.add(unitedValueSet);
        				}
        			}
        	     }
        	}
        }
        
        result = new ArrayList<List<Integer>>(setResult);
        return result;
    }
    
    public boolean checkIntersection(List<Integer> list1, List<Integer> list2) {
        for (Integer temp : list1) {
            if(list2.contains(temp)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Integer> unite(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<Integer>(set);
    }
}
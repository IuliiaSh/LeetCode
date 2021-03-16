import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		Map<String, List<List<String>>> memo = new HashMap<String, List<List<String>>>();
        return partitionRecursive(s, 0, s.length() - 1, memo);
    }
    
    private List<List<String>> partitionRecursive(String s, int start, int end, Map<String, List<List<String>>> memo) {
    	String memoKey = start + "_" + end;
    	if (memo.containsKey(memoKey)) return memo.get(memoKey);
    	
        List<List<String>> result = new ArrayList<List<String>>();
        List<List<String>> nextResult;
        List<String> temp;
        for (int i = start; i <= end; i++) {
            if (checkPolidrome(s, start, i)) {
            	if (i == end) {
            		temp = new ArrayList<String>();
                	temp.add(s.substring(start));
                    result.add(temp);
            	} else {
            		nextResult = partitionRecursive(s, i + 1, end, memo);
	                for (List<String> nr : nextResult) {
	                	temp = new ArrayList<String>();
	                	temp.add(s.substring(start, i + 1));
	                	temp.addAll(nr);
	                    result.add(temp);
	                }
            	}
            }
        }
        memo.put(memoKey, result);
        return result;
    }
    
    private boolean checkPolidrome(String s, int start, int end) {
        for (int i = 0; i < (end - start + 1)/2; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) return false;
        }
        return true;
    }
}

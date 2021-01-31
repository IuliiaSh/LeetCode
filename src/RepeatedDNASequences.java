import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        String currentSubstring;
        int count;
        for (int i = 0; i <= s.length() - 10; i++) {
            currentSubstring = s.substring(i, i + 10);
        	count = counts.containsKey(currentSubstring) ? counts.get(currentSubstring) : 0;
            if (count == 1) result.add(currentSubstring);
                
        	counts.put(currentSubstring, count + 1);
        }
        return result;
    }
}

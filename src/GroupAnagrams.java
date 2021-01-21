import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        char[] currentChars;
        String currentKey;
        List<String> currentValue;
        for (int i = 0; i < strs.length; i++) {
            currentChars = strs[i].toCharArray();
            Arrays.sort(currentChars);
            currentKey = new String(currentChars);
            if (groups.containsKey(currentKey)) {
                groups.get(currentKey).add(strs[i]);
            } else {
                currentValue = new ArrayList<String>();
                currentValue.add(strs[i]);
                groups.put(currentKey, currentValue);
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> value : groups.values()) {
            result.add(value);
        }
        return result;
    }
}

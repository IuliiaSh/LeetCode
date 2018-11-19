import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int currentResult = 0;
        HashMap<Character, Integer> charToIndexMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (charToIndexMap.containsKey(s.charAt(i))) {
                result = Math.max(result, currentResult);
                currentResult = Math.min(currentResult, i - charToIndexMap.get(s.charAt(i)) - 1);
            }
            charToIndexMap.put(s.charAt(i), i);
            currentResult++;
        }
        return Math.max(result, currentResult);
    }
}

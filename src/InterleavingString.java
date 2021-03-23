import java.util.HashSet;
import java.util.Set;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s3.length() == 0) return true;
        
        Set<String> tried = new HashSet<String>();
        return isInterleaveRecursively(s1, s2, s3, 0, 0, 0, tried);
    }
    
    private boolean isInterleaveRecursively(String s1, String s2, String s3,
                                            int s1Index, int s2Index, int s3Index, Set<String> tried) {
        if (s3Index == s3.length()) return true;
        
        String combination;
        boolean firstResult = false;
        if (s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s3Index)) {
            combination = (s1Index + 1) + "_" + s2Index;
            if (!tried.contains(combination)) {
                tried.add(combination);
                firstResult = isInterleaveRecursively(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, tried);
            }
        }
        
        boolean secondResult = false;
        if (s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s3Index)) {
            combination = s1Index + "_" + (s2Index + 1);
            if (!tried.contains(combination)) {
                tried.add(combination);
                secondResult = isInterleaveRecursively(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, tried);
            }
        }
        return firstResult || secondResult;
    }
}
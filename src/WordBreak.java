import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<String>();        
        for (String word : wordDict) {
        	words.add(word);
        }
        int index = 0;
        boolean[] isTried = new boolean[s.length()];
        return wordBreakRecursively(s, index, words, isTried);
    }
    
    private boolean wordBreakRecursively(String s, int index, Set<String> words, boolean[] isTried) {
        if (index == s.length()) return true;
        if (isTried[index]) return false;

        for (int i = index + 1; i <= s.length(); i++) {
            if (words.contains(s.substring(index, i))) {
                if (wordBreakRecursively(s, i, words, isTried)) return true;
            }
        }
        isTried[index] = true; 
        return false;
    }
}
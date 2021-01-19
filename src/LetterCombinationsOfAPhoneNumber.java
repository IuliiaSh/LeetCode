import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	Map<Character, List<String>> lettersFromDigitMap;
	
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) return new ArrayList<String>();
		
		initializeLettersFromDigitMap();
        return letterCombinations(digits, 0);      
    }
    
    private List<String> letterCombinations(String digits, int index){
    	List<String> result = new ArrayList<String>();
    	if (index == digits.length()) {
    		result.add("");
    		return result;
    	}
        
        List<String> letters = lettersFromDigitMap.get(digits.charAt(index));
        List<String> nextCombinations = letterCombinations(digits, index + 1);
        for (String letter : letters) {
            for (String nextCombination : nextCombinations) {
                result.add(letter + nextCombination);
            }
        }
        return result;
    }
    
    private void initializeLettersFromDigitMap() {
    	lettersFromDigitMap = new HashMap<Character, List<String>>();
    	lettersFromDigitMap.put('2', new ArrayList<String>() {{ add("a"); add("b"); add("c"); }});
    	lettersFromDigitMap.put('3', new ArrayList<String>() {{ add("d"); add("e"); add("f"); }});
    	lettersFromDigitMap.put('4', new ArrayList<String>() {{ add("g"); add("h"); add("i"); }});
    	lettersFromDigitMap.put('5', new ArrayList<String>() {{ add("j"); add("k"); add("l"); }});
    	lettersFromDigitMap.put('6', new ArrayList<String>() {{ add("m"); add("n"); add("o"); }});
    	lettersFromDigitMap.put('7', new ArrayList<String>() {{ add("p"); add("q"); add("r"); add("s"); }});
    	lettersFromDigitMap.put('8', new ArrayList<String>() {{ add("t"); add("u"); add("v"); }});
    	lettersFromDigitMap.put('9', new ArrayList<String>() {{ add("w"); add("x"); add("y"); add("z"); }});
    }
}

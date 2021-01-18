public class LongestWordInDictionary {
	DictionaryNode root;
	
    public String longestWord(String[] words) {
    	root = new DictionaryNode();
    	for (int i = 0; i < words.length; i++) {
    		root.addWord(words[i], 0);
    	}
    	return root.longestWord().toString();
    }
}

class DictionaryNode {
	char value;
	boolean isWorld;
	DictionaryNode[] nexts;
	
    public DictionaryNode() {
    	isWorld = false;
    }
    
    public DictionaryNode(char inputValue) {
    	value = inputValue;
    	isWorld = false;
    }
    
    public void addWord(String word, int i) {
    	if (nexts == null) initializeNexts();
    	
    	int index = (int)word.charAt(i) - 97;
    	DictionaryNode node = nexts[index];
        if (word.length() == (i + 1)) {
        	node.isWorld = true;
        } else {
        	node.addWord(word, i + 1);
        }
    }
    
    public StringBuilder longestWord() {
    	StringBuilder result = new StringBuilder();
		for (int index = 0; index < nexts.length; index++) {
			DictionaryNode node = nexts[index];
			if (node.isWorld) {
				StringBuilder currentResult = new StringBuilder();
				currentResult.append(node.value);
				if (node.nexts != null) {
					currentResult.append(node.longestWord());
				}
				
				if (currentResult.length() > result.length()) {
					result = currentResult;
				}
			}
		}
    	return result;
    }
    
    private void initializeNexts() {
    	nexts = new DictionaryNode[26];
        char nextChar;
        for (int i = 0; i < nexts.length; i++) {
            nextChar = (char)(i + 97);
            nexts[i] = new DictionaryNode(nextChar);
        }
	}
}
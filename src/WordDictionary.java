public class WordDictionary {
	WordDictionaryNode root;
	
    public WordDictionary() {
    	root = new WordDictionaryNode();
    }
    
    public void addWord(String word) {
    	root.addWord(word, 0);
    }
    
    public boolean search(String word) {
    	return root.search(word, 0);
    }
}

class WordDictionaryNode {
	char value;
	boolean isWorld;
	WordDictionaryNode[] nexts;
	
    public WordDictionaryNode() {
    	isWorld = false;
    }
    
    public WordDictionaryNode(char inputValue) {
    	value = inputValue;
    	isWorld = false;
    }
    
    public void addWord(String word, int i) {
    	if (nexts == null) initializeNexts();
    	
    	int index = (int)word.charAt(i) - 97;
    	WordDictionaryNode node = nexts[index];
        if (word.length() == (i + 1)) {
        	node.isWorld = true;
        } else {
        	node.addWord(word, i + 1);
        }
    }
    
    public boolean search(String word, int i) {
    	if (nexts == null) return false;
    	
    	char currentChar = word.charAt(i);
    	if (currentChar == '.') {
    		for (int index = 0; index < nexts.length; index++) {
    			WordDictionaryNode node = nexts[index];
    	    	if (word.length() == (i + 1)) {
    	    		if(node.isWorld) return true;
    	    	} else {
    	    		if (node.search(word, i + 1)) return true;
    	    	}
            }
    		return false;
    	} else {
	    	int index = (int)word.charAt(i) - 97;
	    	WordDictionaryNode node = nexts[index];
	    	if (word.length() == (i + 1)) return node.isWorld;
	    	return node.search(word, i + 1);
    	}
    }
    
    private void initializeNexts() {
    	nexts = new WordDictionaryNode[26];
        char nextChar;
        for (int i = 0; i < nexts.length; i++) {
            nextChar = (char)(i + 97);
            nexts[i] = new WordDictionaryNode(nextChar);
        }
	}
}
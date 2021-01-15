public class Trie {
	TrieNode root;
    
    public Trie() {
    	root = new TrieNode();
    }

    public void insert(String word) {
    	root.insert(word, 0);
    }
    
    public boolean search(String word) {
    	return root.search(word, 0);
    }
    
    public boolean startsWith(String word) {
    	return root.startsWith(word, 0);
    }
}

class TrieNode {
	char value;
	boolean isWorld;
	TrieNode[] nexts;
	
    public TrieNode() {
    	isWorld = false;
    }
    
    public TrieNode(char inputValue) {
    	value = inputValue;
    	isWorld = false;
    }
    
    public void insert(String word, int i) {
    	if (nexts == null) initializeNexts();
    	
    	int index = (int)word.charAt(i) - 97;
    	TrieNode node = nexts[index];
        if (word.length() == (i + 1)) {
        	node.isWorld = true;
        } else {
        	node.insert(word, i + 1);
        }
    }
    
    public boolean search(String word, int i) {
    	if (nexts == null) return false;
    	
    	int index = (int)word.charAt(i) - 97;
    	TrieNode node = nexts[index];
    	if (word.length() == (i + 1)) return node.isWorld;
    	return node.search(word, i + 1);
    }
    
    public boolean startsWith(String word, int i) {
    	if (nexts == null) return false;
    	
    	int index = (int)word.charAt(i) - 97;
    	TrieNode node = nexts[index];
    	if (word.length() == (i + 1)) {
    		if (node.nexts != null || node.isWorld) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return node.startsWith(word, i + 1);
    }
    
    private void initializeNexts() {
    	nexts = new TrieNode[26];
        char nextChar;
        for (int i = 0; i < nexts.length; i++) {
            nextChar = (char)(i + 97);
            nexts[i] = new TrieNode(nextChar);
        }
	}
}
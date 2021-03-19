import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PushDominoes {
	public String pushDominoes(String dominoes) {
		dominoes = "." + dominoes + ".";
        char[] result = new char[dominoes.length()];
        for (int i = 0; i < result.length; i++) {
            if (dominoes.charAt(i) != '.') {
                result[i] = dominoes.charAt(i);
            } else {
                result[i] = 'N';
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i < dominoes.length() - 1; i++) {
            if (dominoes.charAt(i) == '.' && 
                ((dominoes.charAt(i - 1) != '.' || dominoes.charAt(i + 1) != '.'))) {
                queue.add(i);
            }
        }
        
        int index;
        Queue<Integer> nextQueue;
        Map<Integer, Character> updates;
        while (!queue.isEmpty()) {
        	updates = new HashMap<Integer, Character>();
        	nextQueue = new LinkedList<Integer>(); 
	        while (!queue.isEmpty()) {
	            index = queue.remove();
	            if (index == 0 || index == result.length - 1 || result[index] != 'N') continue;
	            
	            if (result[index - 1] == 'L' && result[index + 1] == 'L' ||
	                result[index - 1] == 'R' && result[index + 1] == 'R') {
	            	updates.put(index, result[index - 1]);
	            } else if (result[index - 1] == 'L' && result[index + 1] == 'R' ||
	                result[index - 1] == 'R' && result[index + 1] == 'L') {
	            	updates.put(index, '.');
	            } else if (result[index - 1] == 'R' && result[index + 1] == 'N') {
	            	updates.put(index, 'R');
	                nextQueue.add(index + 1);
	            } else if (result[index + 1] == 'L' && result[index - 1] == 'N') {
	            	updates.put(index, 'L');
	                nextQueue.add(index - 1);
	            }
	        }	        
	        queue = nextQueue;      
    		for (Map.Entry<Integer, Character> entry : updates.entrySet()) {
    		    result[entry.getKey()] = entry.getValue();
    		}
        }
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'N') {
                result[i] = '.';
            }
        }  
        String stringResult = new String(result);
        return stringResult.substring(1, result.length-1);
    }
}

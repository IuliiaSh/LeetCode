import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCache {
	private int id;
    private int size;
    private TreeMap<Integer, Integer> usageMap;
    private Map<Integer, Integer> reverseUsageMap;
    private Map<Integer, Integer> valueMap;

    public LRUCache(int capacity) {
        id = 0;
        size = capacity;
        usageMap = new TreeMap<Integer, Integer>();
        reverseUsageMap = new HashMap<Integer, Integer>();
        valueMap = new HashMap<Integer, Integer>();
    }
    
	private void updateUsage(int key) {
		usageMap.remove(reverseUsageMap.get(key));
		usageMap.put(id, key);
		reverseUsageMap.put(key, id);
		id++;
	}
    
    public int get(int key) {
        if (valueMap.get(key) != null) {
        	updateUsage(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	if (valueMap.containsKey(key)) {
    		updateUsage(key);
    	} else {
    		usageMap.put(id, key);
    		reverseUsageMap.put(key, id);
            id++;
    	}
        valueMap.put(key, value);
		
        if (usageMap.size() > size) {
            valueMap.remove(usageMap.pollFirstEntry().getValue());
        }
    }
}

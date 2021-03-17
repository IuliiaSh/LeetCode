import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SortIntegersByThePowerValue {
	public int getKth(int lo, int hi, int k) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
        int key;
        for (int i = lo; i <= hi; i++) {
            key = getPower(i);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            map.get(key).add(i);
        }
        
        List<Integer> currentValue = map.pollFirstEntry().getValue();
        while (currentValue.size() < k) {
            k = k - currentValue.size();
            currentValue = map.pollFirstEntry().getValue();
        }
        Collections.sort(currentValue);
        return currentValue.get(k - 1);
    }
    
    private int getPower(int number) {
        int result = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            result++;
        }
        return result;
    }
}

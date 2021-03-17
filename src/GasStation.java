public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diffs = new int[gas.length];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = gas[i] - cost[i];
        }
        
        int startIndex = 0;
        int sum;
        int currentIndex;
        while (startIndex < diffs.length) {
            sum = 0;
            currentIndex = startIndex;
            while (true) {
            	sum = sum + diffs[currentIndex];
            	if (sum < 0) break;
            	
            	currentIndex = getNextIndex(currentIndex, diffs.length);
            	if (currentIndex == startIndex) return startIndex; 
            }
            startIndex = findNextStartIndex(startIndex, diffs);
        }
        return -1;
    }
    
    private int getNextIndex(int index, int n) {
        if (index + 1 == n) return 0;
        else return index + 1;
    }
    
    private int findNextStartIndex(int index, int[] diffs) {
        while (index < diffs.length && diffs[index] >= 0) {
            index++;
        }
        
        while (index < diffs.length && diffs[index] < 0) {
            index++;
        }
        return index;
    }
}
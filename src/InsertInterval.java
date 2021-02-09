import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && intervals[i][1] < start) {
            addResultEntry(intervals[i][0], intervals[i][1], result);
            i++;
        }
        if (i < intervals.length) start = Math.min(start, intervals[i][0]);
        
        while (i < intervals.length && intervals[i][0] <= end) {
            i++;
        }
        if (i > 0) end = Math.max(end, intervals[i - 1][1]);
        addResultEntry(start, end, result);
        
        while (i < intervals.length) {
            addResultEntry(intervals[i][0], intervals[i][1], result);
            i++;
        }
        return getMatrixFromDoubleList(result);
    }
    
    private void addResultEntry(int currentStart, int currentEnd, List<List<Integer>> result) {
		List<Integer> nextResultEntry;
		nextResultEntry = new ArrayList<Integer>();
		nextResultEntry.add(currentStart);
		nextResultEntry.add(currentEnd);
		result.add(nextResultEntry);
	}
    
    private int[][] getMatrixFromDoubleList(List<List<Integer>> list) {
		int[][] result = new int[list.size()][2];
        for(int i = 0; i < result.length; i++) {
            result[i] = new int[2];
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
		return result;
	}
}
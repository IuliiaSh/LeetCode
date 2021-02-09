import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		sortIntervals(intervals);
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, intervals[i][1]);
            } else {
                addResultEntry(currentStart, currentEnd, result);
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }
        addResultEntry(currentStart, currentEnd, result);
        return getMatrixFromDoubleList(result);
    }
	
    private void sortIntervals(int[][] intervals) {
    	Arrays.sort(intervals, new Comparator<int[]>() {
    		@Override
    		public int compare(int[] o1, int[] o2) {
    			Integer i1 = (Integer) (o1[0]);
    			Integer i2 = (Integer) (o2[0]);
    			return i1.compareTo(i2);
    		}
    	});
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

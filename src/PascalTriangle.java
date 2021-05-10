import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) return result;
        
        List<Integer> current = new ArrayList<Integer>();
        current.add(1);
        result.add(current);
        List<Integer> previous;
        while (numRows > result.size()) {
            previous = result.get(result.size() - 1);
            current = new ArrayList<Integer>();
            current.add(1);
            for (int i = 0; i < previous.size() - 1; i++) {
                current.add(previous.get(i) + previous.get(i + 1));
            }
            current.add(1);
            result.add(current);
        } 
        return result;
    }
}

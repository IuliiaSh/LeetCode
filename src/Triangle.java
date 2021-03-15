import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            result.add(new ArrayList<Integer>());
            result.get(i).add(result.get(i - 1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < triangle.get(i).size() - 1; j++) {
                result.get(i).add(Math.min(result.get(i - 1).get(j - 1), result.get(i - 1).get(j)) +
                    triangle.get(i).get(j));
            }
            result.get(i).add(result.get(i - 1).get(triangle.get(i - 1).size() - 1) + 
            		triangle.get(i).get(triangle.get(i - 1).size()));
        }
        
        int minResult = Integer.MAX_VALUE;
        for (int j = 0; j < result.get(result.size() - 1).size(); j++) {
            if (result.get(result.size() - 1).get(j) < minResult) {
            	minResult = result.get(result.size() - 1).get(j);
            }
        }
        return minResult;
    }
}

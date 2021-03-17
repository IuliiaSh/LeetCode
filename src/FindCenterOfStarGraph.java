import java.util.HashSet;
import java.util.Set;

public class FindCenterOfStarGraph {
	public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                if (set.contains(edges[i][j])) return edges[i][j];
                set.add(edges[i][j]);
            } 
        }
        return -1;
    }
}
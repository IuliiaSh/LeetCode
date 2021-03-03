import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleFour {
	public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		List<Set<Integer>> parents = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
        	parents.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
        	parents.get(prerequisites[i][1]).add((prerequisites[i][0]));
        }
        
        List<Set<Integer>> predecessors = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
        	predecessors.add(new HashSet<Integer>());
        }

		List<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < queries.length; i++) {
			if (predecessors.get(queries[i][1]).isEmpty()) populatePredecessors(parents, predecessors, queries[i][1]);
			
			if (predecessors.get(queries[i][1]).contains(queries[i][0])) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

	private void populatePredecessors(List<Set<Integer>> parents, List<Set<Integer>> predecessors, int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.addAll(parents.get(index));
		
		int current;
		while (!queue.isEmpty()) {
			current = queue.remove();
			if (!predecessors.get(index).contains(current)) {
				predecessors.get(index).add(current);
				
				if (!predecessors.get(current).isEmpty()) {
				    for (int p : predecessors.get(current)) {
				        if (!predecessors.get(index).contains(p)) {
				        	predecessors.get(index).add(p);
				        }
				     }
				} else {
					queue.addAll(parents.get(current));
				}
			}
		}
	}
}
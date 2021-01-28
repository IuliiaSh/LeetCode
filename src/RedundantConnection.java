public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
		int[] predecessors = new int[edges.length + 1];
		for (int i = 0; i < edges.length + 1; i++) {
			predecessors[i] = i;
		}
		
		int[] sizes = new int[edges.length + 1];
		for (int i = 0; i < edges.length + 1; i++) {
			sizes[i] = 1;
		}
		
		for (int i = 0; i < edges.length + 1; i++) {
			int first = edges[i][0];
			int second = edges[i][1];
			if (isConnected(first, second, predecessors)) {
				return edges[i];
			}
			
			connect(first, second, predecessors, sizes);
		}
		return null;
    }
	
	private boolean isConnected(int first, int second, int[] predecessors) {
		return getRoot(first, predecessors) == getRoot(second, predecessors);
	}
    
	private int getRoot(int node, int[] predecessors) {
		while (node != predecessors[node]) {
			predecessors[node] = predecessors[predecessors[node]];
			node = predecessors[node];
		}
		return node;
	}
	
	private void connect(int first, int second, int[] predecessors, int[] sizes) {
		int firstRoot = getRoot(first, predecessors);
		int firstSize = sizes[firstRoot];
		int secondRoot = getRoot(second, predecessors);
		int secondSize = sizes[secondRoot];
		if (firstSize < secondSize) {
			predecessors[firstRoot] = secondRoot;
			sizes[secondRoot] = sizes[firstRoot] + sizes[secondRoot];	
		} else {
			predecessors[secondRoot] = firstRoot;
			sizes[firstRoot] = sizes[firstRoot] + sizes[secondRoot];
		}
	}
}

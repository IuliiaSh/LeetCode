import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    List<Integer> result = new ArrayList<Integer>();
		if (n == 1) {
			result.add(0);
			return result;
		}
		
		Node[] nodes = new Node[n];
		for (int i = 0; i < nodes.length; i++) {
		    nodes[i] = new Node(i);
		}

		for (int i = 0 ; i < edges.length; i++) {
		    nodes[edges[i][0]].neighbors.add(nodes[edges[i][1]]);
		    nodes[edges[i][1]].neighbors.add(nodes[edges[i][0]]);
		}
		
		Queue<Node> currentNodes = new LinkedList<Node>();
		for (int i = 0; i < nodes.length; i++) {
		    if (nodes[i].neighbors.size() == 1) {
		    	currentNodes.add(nodes[i]);
		    }
		}
		
		int nodesLeft = n;
		Queue<Node> previousNodes;
		Node node;
		Node parent;
		boolean[] isOnQueue = new boolean[n];
		while (nodesLeft > 2) {
			previousNodes = currentNodes;
			currentNodes = new LinkedList<Node>();
			isOnQueue = new boolean[n];
			while (!previousNodes.isEmpty()) {
				node = previousNodes.remove();
				if (!isOnQueue[node.val]) {
					if (node.neighbors.size() == 1) {
						nodesLeft--;
						parent = node.neighbors.get(0);
						parent.neighbors.remove(node);
					
						if (!isOnQueue[parent.val]) {
							currentNodes.add(parent);
							isOnQueue[parent.val] = true;
						}
					} else {
						currentNodes.add(node);
						isOnQueue[node.val] = true;
					}
				}
			}
		}
		
        while (!currentNodes.isEmpty()) {
            result.add(currentNodes.remove().val);
        }
		return result;
    }
}

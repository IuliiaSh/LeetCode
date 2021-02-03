import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class PathWithMinimumEffort {
	public int minimumEffortPath(int[][] heights) {
		WeightedNode[][] nodes = new WeightedNode[heights.length][heights[0].length];
		for (int i = 0; i < nodes.length; i++) {
		    for (int j = 0; j < nodes[0].length; j++) {
		        nodes[i][j] = new WeightedNode(); 
		    }
		}

		Edge edge;
		for (int i = 0; i < nodes.length; i++) {
		    for (int j = 0; j < nodes[0].length; j++) {
		        if (i + 1 < nodes.length) {
		            edge = new Edge(nodes[i][j], nodes[i + 1][j], Math.abs(heights[i][j] - heights[i + 1][j]));
		            nodes[i][j].edges.add(edge);
		            nodes[i + 1][j].edges.add(edge);
		        }
		        
		        if (j + 1 < nodes[0].length) {
		            edge = new Edge(nodes[i][j], nodes[i][j + 1], Math.abs(heights[i][j] - heights[i][j + 1]));
		            nodes[i][j].edges.add(edge);
		            nodes[i][j + 1].edges.add(edge);
		        }
		    }
		}
		
		TreeMap<Integer, Stack<WeightedNode>> distanceNodeMap = new TreeMap<Integer, Stack<WeightedNode>>();
		WeightedNode node = nodes[0][0];
		Stack<WeightedNode> currentNodes = new Stack<WeightedNode>();
		currentNodes.add(node);
		int currentDistance = 0;
		distanceNodeMap.put(currentDistance, currentNodes);
		Set<WeightedNode> visitedNodes = new HashSet<WeightedNode>();
		WeightedNode neighbour;
		int neighbourDistance;
		while (true) {
		    currentDistance = distanceNodeMap.firstKey();
		    currentNodes = distanceNodeMap.firstEntry().getValue();
		    node = currentNodes.pop();
		    if (currentNodes.isEmpty()) {
		    	distanceNodeMap.remove(currentDistance);
		    }
		    
		    if (!visitedNodes.contains(node)) {
			    if (node == nodes[nodes.length - 1][nodes[0].length - 1]) return currentDistance;
			        
			    visitedNodes.add(node);
			    for (Edge e : node.edges) {
			    	neighbour = e.getOther(node);
			    	if (!visitedNodes.contains(neighbour)) {
			    		neighbourDistance = Math.max(currentDistance, e.weight);
			    		if (!distanceNodeMap.containsKey(neighbourDistance)) {
			    			distanceNodeMap.put(neighbourDistance, new Stack<WeightedNode>());
			    		}
			    		distanceNodeMap.get(neighbourDistance).push(neighbour);
			    	}	
			    }
		    }
		}
    }
}

class WeightedNode {
    public List<Edge> edges;

    public WeightedNode() {
        this.edges = new ArrayList<Edge>();
    }
}

class Edge {
    WeightedNode first;
    WeightedNode second;
    int weight;
    
    public Edge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
    
    public WeightedNode getOther(WeightedNode node) {
        if (node == first) return second;
        return first;
    }
}

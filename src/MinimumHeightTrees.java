import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            result.add(0);
            return result;
        } 
        if (n == 2) {
            result.add(0);
            result.add(1);
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
		
		int minimumHeight = Integer.MAX_VALUE;
		int currentHeight;
		for (int i = 0; i < nodes.length; i++) {
		    if (nodes[i].neighbors.size() > 1) {
		        currentHeight = getHeight(n, nodes[i], minimumHeight + 1);
		        if (currentHeight == minimumHeight) {
		            result.add(i);
		        } else if (currentHeight < minimumHeight) {
		    	    minimumHeight = currentHeight;
		            result = new ArrayList<Integer>();
		            result.add(i);
		        }
		    }
		}
		return result;
    }
    
	private int getHeight(int n, Node root, int stopHeight) {
        int result = 0;
        Stack<Node> nodes = new Stack<Node>();
        boolean[] isVisited = new boolean[n];
        int[] heights = new int[n];
        nodes.push(root);
        heights[root.val] = 0;
        Node node;
        int height;
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            isVisited[node.val] = true;
            
            height = heights[node.val];
            if (height == stopHeight) return Integer.MAX_VALUE;
            	
            if (height > result) {
                result = height;
            }
            
            for (Node neighbor : node.neighbors) {
                if (!isVisited[neighbor.val]) {
                    nodes.push(neighbor);
                    heights[neighbor.val] = height + 1;
                }
            }
        }
        return result;
    }
}

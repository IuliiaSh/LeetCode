import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
        Node[] nodes = new Node[graph.length];
        for (int i = 0; i < graph.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[i].neighbors.add(nodes[graph[i][j]]);
            }
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        boolean[] isVisited = new boolean[graph.length];
        boolean[] isRed = new boolean[graph.length];
        Node currentNode;
        for (int i = 0; i < graph.length; i++) {
        	if (!isVisited[nodes[i].val]) {
		        queue.add(nodes[i]);
		        while (!queue.isEmpty()) {
		            currentNode = queue.remove();
		            isVisited[currentNode.val] = true;
		            for (Node neighbor : currentNode.neighbors) {            	
		        	    if (isVisited[neighbor.val]) {
		                    if (isRed[neighbor.val] == isRed[currentNode.val]) return false;
		                } else {
		                    isRed[neighbor.val] = !isRed[currentNode.val];
		                    queue.add(neighbor);
		                }
		            }
		        }
        	}
        }
        return true;
    }
}

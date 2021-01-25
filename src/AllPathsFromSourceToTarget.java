import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Node[] nodes = new Node[graph.length];
        for (int i = 0; i < graph.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[i].neighbors.add(nodes[graph[i][j]]);
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentResult = new ArrayList<Integer>();
        Node currentNode = nodes[0];
        findAllPaths(nodes, result, currentResult, currentNode);
        return result;
    }
    
    private void findAllPaths(Node[] nodes, List<List<Integer>> result, List<Integer> currentResult, Node currentNode) {
        currentResult.add(currentNode.val);
        if (currentNode.val == nodes.length - 1) {
            result.add(new ArrayList<Integer>(currentResult));
        } else {
            for (Node neighbor : currentNode.neighbors) {
                findAllPaths(nodes, result, currentResult, neighbor);
            }
        }
        currentResult.remove(currentResult.size() - 1);
    }
}

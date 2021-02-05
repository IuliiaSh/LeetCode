import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        DiNode[] nodes = new DiNode[graph.length];
        for (int i = 0; i < graph.length; i++) {
            nodes[i] = new DiNode(i);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes[i].outNeighbors.add(nodes[graph[i][j]]);
                nodes[graph[i][j]].inNeighbors.add(nodes[i]);
            }
        }
        
        boolean[] isSafe = new boolean[graph.length];
        Queue<DiNode> currentNodes = new LinkedList<DiNode>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].outNeighbors.size() == 0) {
                currentNodes.add(nodes[i]);
                isSafe[i] = true;
            }
        }
        
        DiNode currentNode;
        while (!currentNodes.isEmpty()) {
            currentNode = currentNodes.remove();
            for (DiNode neighbor : currentNode.inNeighbors) {
                neighbor.outNeighbors.remove(currentNode);
                if (neighbor.outNeighbors.size() == 0) {
                    currentNodes.add(neighbor);
                    isSafe[neighbor.val] = true;
                }
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (isSafe[i]) result.add(i);
        }
        return result;
    }
}

class DiNode {
    public int val;
    public List<DiNode> inNeighbors;
    public List<DiNode> outNeighbors;
    
    public DiNode(int val) {
        this.val = val;
        inNeighbors = new ArrayList<DiNode>();
        outNeighbors = new ArrayList<DiNode>();
    }
}
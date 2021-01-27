import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
		DirectedNode[] nodes = new DirectedNode[n + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new DirectedNode(i);
        }

        DirectedEdge edge;
        for (int i = 0; i < times.length; i++) {
            edge = new DirectedEdge(nodes[times[i][0]], nodes[times[i][1]], times[i][2]);
            nodes[times[i][0]].outcomingEdges.add(edge);
        }
        
        int[] propagationTimes = new int[n + 1];
        for (int i = 0; i < propagationTimes.length; i++) {
            propagationTimes[i] = Integer.MAX_VALUE;
        }
        propagationTimes[k] = 0;
        
        boolean[] isVisited = new boolean[n + 1];
        TreeMap<Integer, List<DirectedNode>> currentNodes = new TreeMap<Integer, List<DirectedNode>>();
        Map.Entry<Integer, List<DirectedNode>> entry;
        int closestDistance = 0;
        List<DirectedNode> closestNodes = new ArrayList<DirectedNode>();
        closestNodes.add(nodes[k]);
        currentNodes.put(closestDistance, closestNodes);
        while (!currentNodes.isEmpty()) {
        	entry = currentNodes.pollFirstEntry();
            closestDistance = entry.getKey();
            closestNodes = entry.getValue();
            for (DirectedNode node : closestNodes) {
                relax(propagationTimes, isVisited, currentNodes, closestDistance, node);
            }
        }
        
        int result = -1;
        for (int i = 1; i < propagationTimes.length; i++) {
            if (propagationTimes[i] == Integer.MAX_VALUE) {
                return -1;
            }
            
            if (propagationTimes[i] > result) {
                result = propagationTimes[i];
            }
        }
        return result;
    }

	private void relax(int[] propagationTimes, boolean[] isVisited, TreeMap<Integer, List<DirectedNode>> currentNodes,
			int distance, DirectedNode node) {
		if (isVisited[node.val]) return;
		
		DirectedNode target;
		int targetDistance;
		List<DirectedNode> targetNodes;
		for (DirectedEdge e : node.outcomingEdges) {
		    target = e.target;
		    targetDistance = distance + e.weight;
		    if (targetDistance < propagationTimes[target.val]) {
		        propagationTimes[target.val] = targetDistance;
		    }
		    
		    if (!isVisited[target.val]) {
		        if (currentNodes.containsKey(targetDistance)) {
		            currentNodes.get(targetDistance).add(target);
		        } else {
		        	targetNodes = new ArrayList<DirectedNode>();
		        	targetNodes.add(target);
		            currentNodes.put(targetDistance, targetNodes);
		        }
		    }
		}
		isVisited[node.val] = true;
	}
}

class DirectedNode {
    public int val;
    public List<DirectedEdge> outcomingEdges;
    
    public DirectedNode(int val) {
        this.val = val;
        outcomingEdges = new ArrayList<DirectedEdge>();
    }
}

class DirectedEdge {
    public DirectedNode source;
    public DirectedNode target;
    public int weight;
    
    public DirectedEdge(DirectedNode source, DirectedNode target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}


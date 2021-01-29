import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CloneGraph {
	public Node cloneGraph(Node node) {
        if (node == null) return null;
        
		Node root = new Node(node.val);
		Map<Node, Node> originalToCopyMap = new HashMap<Node, Node>();
		originalToCopyMap.put(node, root);
		Map<Node, Node> copyToOriginalMap = new HashMap<Node, Node>();
		copyToOriginalMap.put(root, node);
		Stack<Node> currentNodes = new Stack<Node>();
		currentNodes.push(root);
		Node copiedNode;
		Node originalNode;
		Node copiedNeighbor;
		String edge;
        Set<String> addedEdges = new HashSet<String>();
		while (!currentNodes.isEmpty()) {
			copiedNode = currentNodes.pop();
			originalNode = copyToOriginalMap.get(copiedNode);
			for (Node originalNeighbor : originalNode.neighbors) {
				if (originalToCopyMap.containsKey(originalNeighbor)) {
					copiedNeighbor = originalToCopyMap.get(originalNeighbor);
					edge = Math.min(copiedNode.val, copiedNeighbor.val) + "_" + Math.max(copiedNode.val, copiedNeighbor.val);
                    if (!addedEdges.contains(edge)) {
					    copiedNode.neighbors.add(copiedNeighbor);
					    copiedNeighbor.neighbors.add(copiedNode);
                        addedEdges.add(edge);
                    }
				} else {
					copiedNeighbor = new Node(originalNeighbor.val);
					copyToOriginalMap.put(copiedNeighbor, originalNeighbor);
					originalToCopyMap.put(originalNeighbor, copiedNeighbor);
					currentNodes.push(copiedNeighbor);
				}
			}
		}
		return root;
    }
}

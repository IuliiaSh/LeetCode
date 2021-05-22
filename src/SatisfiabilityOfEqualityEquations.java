import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SatisfiabilityOfEqualityEquations {
	public boolean equationsPossible(String[] equations) {
        List<String> nonEquality = new ArrayList<>();
        Map<Character, Node> nodes = new HashMap<>();
        Node first;
        Node second;
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                nonEquality.add(e);
            } else {
                if (!nodes.containsKey(e.charAt(0))) nodes.put(e.charAt(0), new Node(e.charAt(0)));
                if (!nodes.containsKey(e.charAt(3))) nodes.put(e.charAt(3), new Node(e.charAt(3)));
                first = nodes.get(e.charAt(0));
                second = nodes.get(e.charAt(3));
                first.neighbours.add(second);
                second.neighbours.add(first);
            }
        }
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> toBeVisited;
        int id = 0;
        Node currentNode;
        for (Map.Entry<Character, Node> entry : nodes.entrySet()) {
        	currentNode = entry.getValue();
            if (!visited.contains(currentNode)) {
                id++;
                toBeVisited = new LinkedList<>();
                toBeVisited.add(currentNode);
                while (!toBeVisited.isEmpty()) {
                    currentNode = toBeVisited.remove();
                    currentNode.componentId = id;
                    for (Node m : currentNode.neighbours) {
                        if (!visited.contains(m)) {
                            visited.add(m);
                            toBeVisited.add(m);
                        }
                    }
                }
            }
        }
        
        for (String e : nonEquality) {
            if (!nodes.containsKey(e.charAt(0))) continue;
            if (!nodes.containsKey(e.charAt(3))) continue;
            if (nodes.get(e.charAt(0)).componentId == nodes.get(e.charAt(3)).componentId) return false;
        }
        return true;
    }
}

class Node {
    char name;
    List<Node> neighbours;
    int componentId;
    
    public Node (char name) {
        this.name = name;
        neighbours = new ArrayList<>();
        componentId = 0;
    }
}

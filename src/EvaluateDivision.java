import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> nodes = new HashMap<String, Node>();
        List<String> equation;
        Node start;
        Node end;
        for (int i = 0; i < equations.size(); i++) {
            equation = equations.get(i);
            if (!nodes.containsKey(equation.get(0))) nodes.put(equation.get(0), new Node(equation.get(0)));
            if (!nodes.containsKey(equation.get(1))) nodes.put(equation.get(1), new Node(equation.get(1)));
            start = nodes.get(equation.get(0));
            end = nodes.get(equation.get(1));
            start.outcoming.add(new Edge(start, end, values[i]));
            end.outcoming.add(new Edge(end, start, 1 / values[i]));
        }
        
        double[] result = new double[queries.size()];
        List<String> query;
        Queue<Node> toBeVisited;
        Queue<Double> divisions;
        Set<Node> visited;       
        Node node;
        double division;
        for (int i = 0; i < queries.size(); i++) {
            query = queries.get(i);
            if (!nodes.containsKey(query.get(0)) || !nodes.containsKey(query.get(1))) {
                result[i] = -1.0;
                continue;
            }
            
            toBeVisited = new LinkedList<>();
            divisions = new LinkedList<>();
            visited = new HashSet<Node>(); 
            start = nodes.get(query.get(0));
            end = nodes.get(query.get(1));
            toBeVisited.add(start);
            divisions.add(1.0);
            visited.add(start);
            while (!toBeVisited.isEmpty()) {
                node = toBeVisited.remove();
                division = divisions.remove(); 

                if (node == end) {
                    if (result[i] != 0) {
                        result[i] = -1;
                        continue;
                    } else {
                        result[i] = division;
                    }
                }
                
                for (Edge e : node.outcoming) {
                    if (!visited.contains(e.end)) {
                	    toBeVisited.add(e.end);
                	    divisions.add(division * e.value);
                        visited.add(e.end);
                    }
                }
            }
            
            if (result[i] == 0) result[i] = -1;
        }
        return result;
    }
}

class Node {
    String name;
    List<Edge> outcoming;
    
    public Node (String name) {
        this.name = name;
        outcoming = new ArrayList<Edge>();
    }
}

class Edge {
    Node start;
    Node end;
    double value;
    
    public Edge (Node start, Node end, double value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}

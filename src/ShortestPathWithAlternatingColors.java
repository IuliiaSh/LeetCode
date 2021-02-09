import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    	DiColoredNode[] nodes = new DiColoredNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new DiColoredNode(i);
        }

        ColoredEdge edge;
        for (int i = 0; i < red_edges.length; i++) {
            edge = new ColoredEdge(nodes[red_edges[i][0]], nodes[red_edges[i][1]], true);
            nodes[red_edges[i][0]].neighbors.add(edge);
        }
        
        for (int i = 0; i < blue_edges.length; i++) {
            edge = new ColoredEdge(nodes[blue_edges[i][0]], nodes[blue_edges[i][1]], false);
            nodes[blue_edges[i][0]].neighbors.add(edge);
        }
        
        int[] redResult = new int[n];
        int[] blueResult = new int[n];
        redResult[0] = 0;
        blueResult[0] = 0;
        for (int i = 1; i < n; i++) {
        	redResult[i] = Integer.MAX_VALUE;
            blueResult[i] = Integer.MAX_VALUE;
        }

        Queue<ColoredEdge> currentEdges = new LinkedList<ColoredEdge>();
        for (ColoredEdge e : nodes[0].neighbors) {
        	currentEdges.add(e);
        }
        while (!currentEdges.isEmpty()) {
            edge = currentEdges.remove();
            edge.isVisited = true;
            if (edge.isRed) {
            	if (redResult[edge.to.val] > blueResult[edge.from.val] + 1) {
            		redResult[edge.to.val] = blueResult[edge.from.val] + 1;
            	}
            } else {
            	if (blueResult[edge.to.val] > redResult[edge.from.val] + 1) {
            		blueResult[edge.to.val] = redResult[edge.from.val] + 1;
            	}
            }
            
            for (ColoredEdge nextEdge : edge.to.neighbors) {
                if (nextEdge.isRed != edge.isRed && !nextEdge.isVisited) {
                    currentEdges.add(nextEdge);
                }
            }
        }

        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            if (redResult[i] < blueResult[i]) {
                result[i] = redResult[i];
            } else {
            	result[i] = blueResult[i];
            }
            
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }
}

class DiColoredNode {
    public int val;
    public List<ColoredEdge> neighbors;
    
    public DiColoredNode(int val) {
        this.val = val;
        neighbors = new ArrayList<ColoredEdge>();
    }
}

class ColoredEdge {
    public DiColoredNode from;
    public DiColoredNode to;
    public boolean isRed;
    public boolean isVisited;
    
    public ColoredEdge(DiColoredNode from, DiColoredNode to, boolean isRed) {
        this.from = from;
        this.to = to;
        this.isRed = isRed;
        this.isVisited = false;
    }
}

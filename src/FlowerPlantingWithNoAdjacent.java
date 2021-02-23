import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FlowerPlantingWithNoAdjacent {
    int[] result;
	
	public int[] gardenNoAdj(int n, int[][] paths) {
		result = new int[n + 1];		
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < paths.length; i++) {
            nodes[paths[i][0]].neighbors.add(nodes[paths[i][1]]);
            nodes[paths[i][1]].neighbors.add(nodes[paths[i][0]]);
        }

        Queue<Node> currentNodes;
        int[] colors = new int[nodes.length];
        for (int i = 1; i < nodes.length; i++) {
        	if (result[nodes[i].val] == 0) {
                result[nodes[i].val] = 1;
        		currentNodes = new LinkedList<Node>();
        		currentNodes.add(nodes[i]);
        		colors[nodes[i].val] = 1;
        		findFlowerPlanting(currentNodes, colors);
        	}
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }

	private boolean findFlowerPlanting(Queue<Node> currentNodes, int[] colors) {
		Node node = currentNodes.remove();
		for (Node neighbor : node.neighbors) {
			if (colors[neighbor.val] == colors[node.val]) {
				return false;
			} else if (colors[neighbor.val] == 0) {
				for (int i = 1; i <= 4; i++) {
					if (i != colors[node.val]) {
						currentNodes.add(neighbor);
						colors[neighbor.val] = i;
						if (findFlowerPlanting(currentNodes, colors)) {
							result[neighbor.val] = colors[neighbor.val];
							break;
						}
					}
				}
			}	
		}
		return true;
	}
}
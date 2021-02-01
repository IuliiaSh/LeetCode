import java.util.Stack;

public class PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int i = 0; i < dislikes.length; i++) {
            nodes[dislikes[i][0]].neighbors.add(nodes[dislikes[i][1]]);
            nodes[dislikes[i][1]].neighbors.add(nodes[dislikes[i][0]]);
        }
        
        boolean[] isVisited = new boolean[N + 1];
        boolean[] isRed = new boolean[N + 1];
        Stack<Node> currentNodes = new Stack<Node>();
        Node currentNode;
        for (int i = 1; i < nodes.length; i++) {
            if (!isVisited[i]) {
                currentNodes.push(nodes[i]);
                while (!currentNodes.isEmpty()) {
                    currentNode = currentNodes.pop();
                    isVisited[currentNode.val] = true;
                    for (Node neighbor : currentNode.neighbors) {
                        if (isVisited[neighbor.val]) {
                            if (isRed[neighbor.val] == isRed[currentNode.val]) return false;
                        } else {
                            isRed[neighbor.val] = !isRed[currentNode.val];
                            currentNodes.push(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}

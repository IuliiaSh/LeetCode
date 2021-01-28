import java.util.Stack;

public class RegionsCutBySlashes {
	public int regionsBySlashes(String[] grid) {
        int n = 0;
        Node[][][] gridNodes = new Node[grid.length][grid.length][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < 4; k++) {
                    gridNodes[i][j][k] = new Node(n);
                    n++;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (isInMatrix(i - 1, j, grid.length)) connect(i, j, 0, i - 1, j, 2, gridNodes);
                if (isInMatrix(i, j - 1, grid.length)) connect(i, j, 1, i, j - 1, 3, gridNodes);
                if (isInMatrix(i + 1, j, grid.length)) connect(i, j, 2, i + 1, j, 0, gridNodes);
                if (isInMatrix(i, j + 1, grid.length)) connect(i, j, 3, i, j + 1, 1, gridNodes);
                
                switch(grid[i].charAt(j)) {
                    case '\\':
                        connect(i, j, 0, i, j, 3, gridNodes);
                        connect(i, j, 1, i, j, 2, gridNodes);
                        break;
                    case '/':
                        connect(i, j, 0, i, j, 1, gridNodes);
                        connect(i, j, 2, i, j, 3, gridNodes);
                        break;
                    default:
                        connect(i, j, 0, i, j, 1, gridNodes);
                        connect(i, j, 1, i, j, 2, gridNodes);
                        connect(i, j, 2, i, j, 3, gridNodes);
                        connect(i, j, 0, i, j, 3, gridNodes);
                }
            }
        }
        
        Node[] nodes = new Node[n];
        n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < 4; k++) {
                    nodes[n] = gridNodes[i][j][k];
                    n++;
                }
            }
        }
        
        int componentNumber = 0;
        Stack<Node> currentNodes = new Stack<Node>();
        Node currentNode;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[nodes[i].val]) {
                componentNumber++;
                currentNodes.push(nodes[i]);
                while (!currentNodes.isEmpty()) {
                    currentNode = currentNodes.pop();
                    isVisited[currentNode.val] = true;
                    for (Node neighbor : currentNode.neighbors) {
                    	if (!isVisited[neighbor.val]) { 
                    		currentNodes.push(neighbor);
                    	}
                    }
                }
            }
        }
        return componentNumber;
    }
    
    private boolean isInMatrix(int i, int j, int gridLength) {
        if (i < 0 || i >= gridLength || j < 0 || j >= gridLength) return false;
        return true;
    }
    
    private void connect(int i1, int j1, int k1, int i2, int j2, int k2, Node[][][] gridNodes) {
        gridNodes[i1][j1][k1].neighbors.add(gridNodes[i2][j2][k2]);
        gridNodes[i2][j2][k2].neighbors.add(gridNodes[i1][j1][k1]);
    }
}

public class ValidateBinaryTreeNodes {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int edgeCount = 0;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        boolean[] isChild = new boolean[n];
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1) {
                if (isChild[leftChild[i]]) return false;
                isChild[leftChild[i]] = true;
                
                if (isUnited(i, leftChild[i], parent)) return false;
                unite(i, leftChild[i], parent, size);
                edgeCount++;
            }
        }
        
        for (int i = 0; i < rightChild.length; i++) {
            if (rightChild[i] != -1) {
                if (isChild[rightChild[i]]) return false;
                isChild[rightChild[i]] = true;
                
                if (isUnited(i, rightChild[i], parent)) return false;
                unite(i, rightChild[i], parent, size);
                edgeCount++;
            }
        }
        
        if (edgeCount != n - 1) return false;
        return true;
    }
    
    private boolean isUnited(int first, int second, int[] parent) {
        int firstParent = getParent(parent, first);        
        int secondParent = getParent(parent, second);
        if (firstParent == secondParent) return true;
        return false;
    }
    
    private void unite(int first, int second, int[] parent, int[] size) {
        int firstParent = getParent(parent, first);
        int secondParent = getParent(parent, second);       
        if (size[firstParent] >= size[secondParent]) {
            parent[secondParent] = firstParent;
            size[firstParent] = size[firstParent] + size[secondParent];
            
        } else {
            parent[firstParent] = secondParent;
            size[secondParent] = size[firstParent] + size[secondParent];
        }
    }

	private int getParent(int[] parent, int node) {
		while (node != parent[node]) {
        	parent[node] = parent[parent[node]];
        	node = parent[node];
        }
		return node;
	}
}
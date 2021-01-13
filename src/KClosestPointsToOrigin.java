import java.util.ArrayList;
import java.util.List;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
    	if (points.length < K) return null;
    	
    	int[][] result = new int[K][2];
    	MinHeap heap = new MinHeap();
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);
        }
        
        for (int i = 0; i < K; i++) {
        	result[i] = heap.remove();
        }
        return result;
    }
}

class MinHeap {
    List<HeapNode> nodes;
    
    MinHeap() {
        nodes = new ArrayList<HeapNode>();
        int[] startPoint = {0, 0};
        nodes.add(new HeapNode(startPoint));
    }
    
    boolean isEmpty() {
        return nodes.size() == 1;
    }
    
    void add(int[] point) {
        int index = nodes.size();
        nodes.add(new HeapNode(point));
        
        int parentIndex;
        while (index != 1) {
            parentIndex = index/2;
            if(nodes.get(parentIndex).compareTo(nodes.get(index)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                index = 1;
            }
        }
    }
    
    int[] remove() {
        swap(1, nodes.size() - 1);
        int[] result = nodes.remove(nodes.size() - 1).point;
        
        int index = 1;
        int firstChildIndex;
        int secondChildIndex;
        double value;
        double firstChildValue;
        double secondChildValue;
        while (true) {
            firstChildIndex = 2 * index;
            if (firstChildIndex >= nodes.size()) break;
            firstChildValue = nodes.get(firstChildIndex).value;
                
            secondChildIndex = 2 * index + 1;
            if (secondChildIndex >= nodes.size()) {
                secondChildValue = Integer.MAX_VALUE;
            } else {
                secondChildValue = nodes.get(secondChildIndex).value;
            }
            
            value = nodes.get(index).value;
            if (firstChildValue < value && firstChildValue <= secondChildValue) {
                swap(firstChildIndex, index);
                index = firstChildIndex;
            } else if (secondChildValue < value && secondChildValue < firstChildValue) {
                swap(secondChildIndex, index);
                index = secondChildIndex;
            } else {
                break;
            }
        }
        return result;
    }
    
    private void swap(int firstIndex, int secondIndex) {
    	HeapNode temp = nodes.get(firstIndex);
        nodes.set(firstIndex, nodes.get(secondIndex));
        nodes.set(secondIndex, temp);
    }
}

class HeapNode implements Comparable<HeapNode> {
	double value;
    int[] point;
    
    HeapNode(int[] point) {
        this.point = point;
        this.value = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

	@Override
	public int compareTo(HeapNode otherNode) {
		return Double.compare(this.value, otherNode.value);
	}
}

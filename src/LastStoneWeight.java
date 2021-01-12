import java.util.ArrayList;
import java.util.List;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
        MaxHeap heap = new MaxHeap();
        for (int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }
        
        int first;
        int second;
        while (!heap.isEmpty()) {
            first = heap.remove();
            if (heap.isEmpty()) return first;
            
            second = heap.remove();
            if (first != second) {
                 heap.add(first - second);
            }
        }
        return 0;
    }
}

class MaxHeap {
    List<Integer> nodes;
    
    MaxHeap() {
        nodes = new ArrayList<Integer>();
        nodes.add(0);
    }
    
    boolean isEmpty() {
        return nodes.size() == 1;
    }
    
    void add(int value) {
        int index = nodes.size();
        nodes.add(value);
        
        int parentIndex;
        while (index != 1) {
            parentIndex = index/2;
            if (nodes.get(parentIndex) < nodes.get(index)) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                index = 1;
            }
        }
    }
    
    int remove() {
        swap(1, nodes.size() - 1);
        int result = nodes.remove(nodes.size() - 1);
        
        int index = 1;
        int firstChildIndex;
        int secondChildIndex;
        int value;
        int firstChildValue;
        int secondChildValue;
        while (true) {
            firstChildIndex = 2 * index;
            if (firstChildIndex >= nodes.size()) break;
            firstChildValue = nodes.get(firstChildIndex);
                
            secondChildIndex = 2 * index + 1;
            if (secondChildIndex >= nodes.size()) {
                secondChildValue = Integer.MIN_VALUE;
            } else {
                secondChildValue = nodes.get(secondChildIndex);
            }
            
            value = nodes.get(index);
            if (firstChildValue > value && firstChildValue >= secondChildValue) {
                swap(firstChildIndex, index);
                index = firstChildIndex;
            } else if (secondChildValue > value && secondChildValue > firstChildValue) {
                swap(secondChildIndex, index);
                index = secondChildIndex;
            } else {
                break;
            }
        }
        return result;
    }
    
    private void swap(int firstIndex, int secondIndex) {
        int temp = nodes.get(firstIndex);
        nodes.set(firstIndex, nodes.get(secondIndex));
        nodes.set(secondIndex, temp);
    }
}

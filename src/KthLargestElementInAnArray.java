import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kLargest = new PriorityQueue<Integer>(k);
        int i = 0;
        while (kLargest.size() < k) {
            kLargest.add(nums[i]);
            i++;
        }
        
        while (i < nums.length) {
            if (kLargest.peek() < nums[i]) {
                kLargest.remove();
                kLargest.add(nums[i]);
            }
            i++;
        }
        return kLargest.peek();
    }
}

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            
            i--;
        }
        
        int j;
        if (i >= 0) {
            j = nums.length - 1;
            while (nums[j] <= nums[i]) {
            	j--;
            }
            
            swap(i, j, nums);
        }
        
        i = i + 1;
        j = nums.length - 1;
        while (i < j)
        {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

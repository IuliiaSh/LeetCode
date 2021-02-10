public class SortColors {
	public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            switch(nums[i]) {
                case 0:
                    redCount++;
                    break;
                case 1:
                    whiteCount++;
                break;
                case 2:
                    blueCount++;
                break;
            }
        }
        
        int j = 0;
        while (redCount > 0) {
            nums[j] = 0;
            redCount--;
            j++;
        }
        while (whiteCount > 0) {
            nums[j] = 1;
            whiteCount--;
            j++;
        }
        while (blueCount > 0) {
            nums[j] = 2;
            blueCount--;
            j++;
        }
    }
}

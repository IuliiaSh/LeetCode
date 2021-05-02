public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++; 
                zeroIndex = i;
            } else {
                product = product * nums[i];
            }
        }
        
        if (zeroCount < 1) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        } else if (zeroCount == 1) {
            result[zeroIndex] = product;
        }
        return result;
    }
}

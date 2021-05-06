public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] isSeen = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (isSeen[nums[i]]) return nums[i];
            isSeen[nums[i]] = true;
        }
        return 0;
    }
}

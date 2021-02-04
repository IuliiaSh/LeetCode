public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        int currentResult;
        while (i != j) {
            currentResult = (j - i) * Math.min(height[i], height[j]);
            if (currentResult > result) result = currentResult;
            
        	if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
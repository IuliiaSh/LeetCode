public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
    	
        int startIndex = 0;
        int endIndex = matrix.length * matrix[0].length - 1;
        int middleIndex;
        int current;
        while (startIndex <= endIndex) {
        	middleIndex = (startIndex + endIndex)/2;
        	current = matrix[middleIndex / matrix[0].length][middleIndex % matrix[0].length];
        	if (current == target) {
        		return true;
        	} else if (current < target) {
        		startIndex = middleIndex + 1;
        	} else {
        		endIndex = middleIndex - 1;
        	}
        }
        return false;
    }
}
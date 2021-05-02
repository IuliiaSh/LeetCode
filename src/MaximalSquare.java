public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        int result = 0;
        int currentRow;
        int currentColumn;
        int height = 0;
        int width;
        int minWidth = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == '1') {
                    currentRow = row;
                    height = 0;
                    while (currentRow < matrix.length && matrix[currentRow][column] == '1') {
                    	height++;
                        currentRow++;
                    }
                    
                    if (Math.pow(height, 2) > result) {
                    	minWidth = Integer.MAX_VALUE;
                    	currentRow = row;
                    	while (currentRow < row + height) {
                    		currentColumn = column;
                    		width = 0;
                    		while (currentColumn < matrix[0].length && matrix[currentRow][currentColumn] == '1') {
                    			width++;
                    			currentColumn++;
                    		}
                    	
                    		if (width < minWidth) {
                    			if (Math.pow(Math.min(currentRow - row, minWidth), 2) > result) {
                    				result = (int) Math.pow(Math.min(currentRow - row, minWidth), 2); 
                    			}
                    			minWidth = width;
                    		}
                    		currentRow++;
                    	}
                    
                    	if (Math.pow(Math.min(height, minWidth), 2) > result) {
                    		result = (int) Math.pow(Math.min(height, minWidth), 2); 
                    	}
                    }
                }  
            }
        }
        return result;
    }
}

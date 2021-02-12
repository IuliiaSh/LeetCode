public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
    	if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
    	
    	int[][] result = new int[grid.length][grid[0].length];
    	int currentResult = 0;
    	for (int i = 0; i < grid.length; i++) {
    		currentResult = currentResult + grid[i][0];
    		result[i][0] = currentResult;
    	}
    	
    	currentResult = 0;
    	for (int j = 0; j < grid[0].length; j++) {
    		currentResult = currentResult + grid[0][j];
    		result[0][j] = currentResult;
    	}
    	
    	for (int i = 1; i < grid.length; i++) {
    		for (int j = 1; j < grid[0].length; j++) {
        		result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]);
        	}
    	}
        return result[grid.length - 1][grid[0].length - 1];
    }
}

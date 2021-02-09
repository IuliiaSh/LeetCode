public class SpiralMatrixTwo {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		result[0][0] = 1;
		int i = 0;
		int j = 0;
		int nextValue = 2;
		Direction direction = Direction.RIGHT; 
		while (nextValue <= n * n) {
		    switch (direction) {
		        case RIGHT: 
		            while (isInMatrix(n, i, j + 1) && result[i][j + 1] == 0) {
		            	j++;
		            	result[i][j] = nextValue;
		            	nextValue++;
		            }
		            direction = Direction.DOWN;   
		            break;
		        case DOWN: 
		            while (isInMatrix(n, i + 1, j) && result[i + 1][j] == 0) {
		            	i++;
		            	result[i][j] = nextValue;
		            	nextValue++;
		            }
		            direction = Direction.LEFT;   
		            break;
		        case LEFT: 
		            while (isInMatrix(n, i, j - 1) && result[i][j - 1] == 0) {
		            	j--;
		            	result[i][j] = nextValue;
		            	nextValue++;
		            }
		            direction = Direction.UP;   
		            break;
		        case UP: 
		            while (isInMatrix(n, i - 1, j) && result[i - 1][j] == 0) {
		            	i--;
		            	result[i][j] = nextValue;
		            	nextValue++;
		            }
		            direction = Direction.RIGHT;   
		            break;
		    }  
		}
		return result;
    }

	private boolean isInMatrix(int n, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) return false;
		return true;
	}
}

enum Direction {
	RIGHT, 
	DOWN, 
	LEFT, 
	UP
}
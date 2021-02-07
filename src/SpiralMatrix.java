import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 1 || matrix[0].length == 1) {
        	for (int i = 0; i < matrix.length; i++) {
        	    for (int j = 0; j < matrix[0].length; j++) {
        	    	result.add(matrix[i][j]);
        	    }
        	}
            return result;
        }
        
        int i = 0;
        int j = 0;
        int[] visitedCount = {0};
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        for (j = 0; j < matrix[0].length; j++) {
        	visitCell(matrix, 0, j, result, visitedCount, isVisited);
        }
        for (i = 1; i < matrix.length; i++) {
        	visitCell(matrix, i, matrix[0].length - 1, result, visitedCount, isVisited);
        }
        for (j = matrix[0].length - 2; j >= 0; j--) {
        	visitCell(matrix, matrix.length -1, j, result, visitedCount, isVisited);
        }
        for (i = matrix.length - 2; i > 0; i--) {
        	visitCell(matrix, i, 0, result, visitedCount, isVisited);
        }
        
        i = 1;
        j = 0;
        Direction direction = Direction.RIGHT; 
        while (visitedCount[0] < matrix.length * matrix[0].length) {
            switch (direction) {
                case RIGHT: 
                    while (!isVisited[i][j + 1]) {
                    	j++;
                    	visitCell(matrix, i, j, result, visitedCount, isVisited);
                    }
                    direction = Direction.DOWN;   
                    break;
                case DOWN: 
                    while (!isVisited[i + 1][j]) {
                    	i++;
                    	visitCell(matrix, i, j, result, visitedCount, isVisited);
                    }
                    direction = Direction.LEFT;   
                    break;
                case LEFT: 
                    while (!isVisited[i][j - 1]) {
                    	j--;
                    	visitCell(matrix, i, j, result, visitedCount, isVisited);
                    }
                    direction = Direction.UP;   
                    break;
                case UP: 
                    while (!isVisited[i - 1][j]) {
                    	i--;
                        visitCell(matrix, i, j, result, visitedCount, isVisited);
                    }
                    direction = Direction.RIGHT;   
                    break;
            }   
        }
        return result;
    }

	private void visitCell(int[][] matrix, int i, int j, 
			List<Integer> result, int[] visitedCount, boolean[][] isVisited) {
		result.add(matrix[i][j]);
		isVisited[i][j] = true;
		visitedCount[0]++;
	}
}

enum Direction {
	  RIGHT, 
	  DOWN, 
	  LEFT, 
	  UP
}
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
	public int maxDistance(int[][] grid) {
        Queue<Cell> current = new LinkedList<Cell>();
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if ((isInGrid(i - 1, j, grid) && grid[i - 1][j] == 1) ||
                       (isInGrid(i + 1, j, grid) && grid[i + 1][j] == 1) ||
                       (isInGrid(i, j - 1, grid) && grid[i][j - 1] == 1) ||
                       (isInGrid(i, j + 1, grid) && grid[i][j + 1] == 1)) {
                        current.add(new Cell(i, j));
                        isVisited[i][j] = true;
                    }
                }
            }
        }        
        if (current.isEmpty() || current.size() == grid.length * grid[0].length) return -1;

        int result = 0;
        Queue<Cell> previous;
        Cell currentCell;
        while (!current.isEmpty()) {
            result++;
            previous = current;
            current = new LinkedList<Cell>();
            while (!previous.isEmpty()) {
                currentCell = previous.remove();
                tryMove(grid, isVisited, current, currentCell.x - 1, currentCell.y);
                tryMove(grid, isVisited, current, currentCell.x + 1, currentCell.y);
                tryMove(grid, isVisited, current, currentCell.x, currentCell.y - 1);
                tryMove(grid, isVisited, current, currentCell.x, currentCell.y + 1);
            }
        }
        return result;
    }

	private void tryMove(int[][] grid, boolean[][] isVisited, Queue<Cell> current, int x, int y) {
		if (isInGrid(x, y, grid) && grid[x][y] == 0 && !isVisited[x][y]) {
		    current.add(new Cell(x, y));
		    isVisited[x][y] = true;
		}
	}
    
    public boolean isInGrid(int x, int y, int[][] grid) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) return false;
        return true;
    }
}

class Cell {
    int x;
    int y;
    
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MapOfHighestPeak {
	public int[][] highestPeak(int[][] isWater) {
        int[][] result = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = -1;
            }
        }
        
        int currentHight = 0;
        Queue<Cell> currentCells = new LinkedList<Cell>();
        Cell current;
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    result[i][j] = currentHight;
                    current = new Cell(i, j);
                    currentCells.add(current);
                }
            }
        }

        Queue<Cell> nextCells = new LinkedList<Cell>();
        List<Cell> neighbours;
        while (!currentCells.isEmpty()) {
            currentHight++;
            while (!currentCells.isEmpty()) {
                current = currentCells.remove();
                neighbours = current.getOnBoardNeighbours(result);
                for (Cell c : neighbours) {
                    if (result[c.x][c.y] == -1) {
                        result[c.x][c.y] = currentHight;
                        nextCells.add(c);
                    }
                }
            }
            currentCells = new LinkedList<Cell>(nextCells);
            nextCells = new LinkedList<Cell>();
            
        }
        return result;
    }
}
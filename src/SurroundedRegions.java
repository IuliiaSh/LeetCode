import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public void solve(char[][] board) {
        char[][] result = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                result[i][j] = 'X';
            }
        }
        
        BoardCell cell;
        for (int i = 0; i < board.length; i++) {
        	cell = new BoardCell(i, 0);
        	cell.process(board, result);
        } 
        for (int i = 0; i < board.length; i++) {
        	cell = new BoardCell(i, board[0].length - 1);
        	cell.process(board, result);
        } 
        for (int j = 0; j < board[0].length; j++) {
        	cell = new BoardCell(0, j);
        	cell.process(board, result);
        } 
        for (int j = 0; j < board[0].length; j++) {
        	cell = new BoardCell(board.length - 1, j);
        	cell.process(board, result);
        }  
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
            	board[i][j] = result[i][j];
            }
        }
    }
}

class BoardCell {
    public int x;
    public int y;

    public BoardCell(int x, int y) {
        this.x = x;
        this.y = y;
    }
        
    void process(char[][] board, char[][] result) {
    	if (result[x][y] != 'X' || board[x][y] != 'O') return;
    	
		Queue<BoardCell> cells = new LinkedList<BoardCell>();
		cells.add(this);
		BoardCell currentCell;        
		while (!cells.isEmpty()) {
		    currentCell = cells.remove();
		    if (currentCell.isOnBoard(board) && result[currentCell.x][currentCell.y] == 'X' && 
		    		board[currentCell.x][currentCell.y] == 'O') {
		        result[currentCell.x][currentCell.y] = 'O';
		        cells.add(new BoardCell(currentCell.x - 1, currentCell.y));
		        cells.add(new BoardCell(currentCell.x, currentCell.y + 1)); 
		        cells.add(new BoardCell(currentCell.x + 1, currentCell.y));
		        cells.add(new BoardCell(currentCell.x, currentCell.y - 1));
		    }
		}
	}
    
    boolean isOnBoard (char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return true;
    }
}
public class GameOfLife {
	public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        int count;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                count = 0;
                if (isOnBoard(i-1, j, board) && board[i-1][j] == 1) count++;
                if (isOnBoard(i+1, j, board) && board[i+1][j] == 1) count++;
                if (isOnBoard(i, j-1, board) && board[i][j-1] == 1) count++;
                if (isOnBoard(i, j+1, board) && board[i][j+1] == 1) count++;
                if (isOnBoard(i-1, j-1, board) && board[i-1][j-1] == 1) count++;
                if (isOnBoard(i-1, j+1, board) && board[i-1][j+1] == 1) count++;
                if (isOnBoard(i+1, j-1, board) && board[i+1][j-1] == 1) count++;
                if (isOnBoard(i+1, j+1, board) && board[i+1][j+1] == 1) count++;
                
                //Any live cell with two or three live neighbors lives on to the next generation.
                if (board[i][j] == 1 && (count == 2 || count == 3)) result[i][j] = 1;
                
                //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                if (board[i][j] == 0 && count == 3) result[i][j] = 1;
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    
    private boolean isOnBoard(int i, int j, int[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        return true;
    }
}

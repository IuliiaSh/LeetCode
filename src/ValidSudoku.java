public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
        boolean[] isPresent;
        for (int i = 0; i < 9; i++) {
            isPresent = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (isPresent[Character.getNumericValue(board[i][j])]) return false;
                    
                    isPresent[Character.getNumericValue(board[i][j])] = true;
                }
            }
        }
        
        for (int j = 0; j < 9; j++) {
            isPresent = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (isPresent[Character.getNumericValue(board[i][j])]) return false;
                    
                    isPresent[Character.getNumericValue(board[i][j])] = true;
                }
            }
        }
        
        boolean isValidSubBox;
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                isValidSubBox = checkSubBox(board, i, j);
                if (!isValidSubBox) return false;
            }
        }
        return true;
    }
    
    private boolean checkSubBox(char[][] board, int startI, int startJ) {
        boolean[] isPresent = new boolean[10];
        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                if (board[i][j] != '.') {
                    if (isPresent[Character.getNumericValue(board[i][j])]) return false;
                    
                    isPresent[Character.getNumericValue(board[i][j])] = true;
                }
            }
        }
        return true;
    }
}

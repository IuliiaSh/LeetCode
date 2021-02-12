public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1) {
            if (word.length() == 1 && board[0][0] == word.charAt(0)) return true;
            return false;
        }
        
        boolean[][] isUsed;
        int currentChar;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                isUsed = new boolean[board.length][board[0].length];
                currentChar = 0;
                if (findWord(board, word, isUsed, currentChar, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean findWord(char[][] board, String word, 
                             boolean[][] isUsed, int currentChar, int currentI, int currentJ) {
        if (isUsed[currentI][currentJ] || board[currentI][currentJ] != word.charAt(currentChar)) return false;
        if (word.length() - 1 == currentChar) return true;

        boolean result = false;
        if (isOnBoard(board, currentI - 1, currentJ)) {
            isUsed[currentI][currentJ] = true;
            result = result || findWord(board, word, isUsed, currentChar + 1, currentI - 1, currentJ);
            isUsed[currentI][currentJ] = false;
        }
        if (isOnBoard(board, currentI, currentJ + 1)) {
            isUsed[currentI][currentJ] = true;
            result = result || findWord(board, word, isUsed, currentChar + 1, currentI, currentJ + 1);
            isUsed[currentI][currentJ] = false;
        }
        if (isOnBoard(board, currentI + 1, currentJ)) {
            isUsed[currentI][currentJ] = true;
            result = result || findWord(board, word, isUsed, currentChar + 1, currentI + 1, currentJ);
            isUsed[currentI][currentJ] = false;
        }
        if (isOnBoard(board, currentI, currentJ - 1)) {
            isUsed[currentI][currentJ] = true;
            result = result || findWord(board, word, isUsed, currentChar + 1, currentI, currentJ - 1);
            isUsed[currentI][currentJ] = false;
        }
        return result;
    }
    
    private boolean isOnBoard(char[][] board, int currentI, int currentJ) {
        if (currentI < 0 || currentI>= board.length ||
            currentJ < 0 || currentJ>= board[0].length) return false;
        return true;
    }
}

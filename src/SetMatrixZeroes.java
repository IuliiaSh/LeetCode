public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        boolean[] isRowZero = new boolean[matrix.length];
        boolean[] isColumnZero = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    isRowZero[i] = true;
                    isColumnZero[j] = true;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isRowZero[i] || isColumnZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

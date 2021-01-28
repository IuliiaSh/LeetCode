public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            rotateRing(matrix, i);
        }
    }
    
    public void rotateRing(int[][] matrix, int index) {
        int temp;
        int start = index;
        int end = matrix.length - index - 1;
        for (int offset = 0; offset < matrix.length - 2*index - 1; offset++) {
            temp = matrix[start][start + offset];
            matrix[start][start + offset] = matrix[end - offset][start];
            matrix[end - offset][start] = matrix[end][end - offset];
            matrix[end][end - offset] = matrix[start + offset][end];
            matrix[start + offset][end] = temp;
        }
    }
}

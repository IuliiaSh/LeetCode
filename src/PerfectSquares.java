public class PerfectSquares {
	public int numSquares(int n) {
        int closestSquare = (int) Math.sqrt(n);
        int[] squares = new int[closestSquare + 1];
        int[] memo = new int[n + 1];
        for (int i = 1; i <= closestSquare; i++) {
            squares[i] = (i*i);
        }        
        return numSquaresRecursively(n, squares, memo);
    }
    
    private int numSquaresRecursively(int n, int[] squares, int[] memo) {
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];
        
        int result = Integer.MAX_VALUE;
        int currentResult;
        int closestSquare = (int) Math.sqrt(n);
        for (int i = closestSquare; i > 0; i--) {
            currentResult = 1 + numSquaresRecursively(n - squares[i], squares, memo);
            if (currentResult < result) {
                result = currentResult;
            }
        }
        memo[n] = result;
        return result;
    }
}

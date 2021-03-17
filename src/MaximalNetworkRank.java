public class MaximalNetworkRank {
	public int maximalNetworkRank(int n, int[][] roads) {
		int[] roadNumbers = new int[n];
		int[][] roadsGraph = new int[n][n];
	    for (int i = 0; i < roads.length; i++) {
	    	roadNumbers[roads[i][0]]++;
	    	roadNumbers[roads[i][1]]++;
	    	roadsGraph[roads[i][0]][roads[i][1]] = 1;
	    	roadsGraph[roads[i][1]][roads[i][0]] = 1;
	    }
	    
	    int result = 0;
	    int currentResult; 
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (i == j) continue;
	            
	            currentResult = roadNumbers[i] + roadNumbers[j] - roadsGraph[i][j];
	            if (currentResult > result) result = currentResult;
	        }
	    }
	    return result;
	}
}

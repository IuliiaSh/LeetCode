public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
    	int[] trustsToCount = new int[N + 1];
        int[] trustedByCount = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
        	trustsToCount[trust[i][0]]++;
            trustedByCount[trust[i][1]]++;
        }
        
        int judge = -1;
        for (int i = 1; i <= N; i++) {
            if (trustsToCount[i] == 0 && trustedByCount[i] == N - 1) {
            	if (judge != -1) return judge;
            	
            	judge = i;
            }
        }
        return judge;
    }
}
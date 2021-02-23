public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int[] inhabitantRowCount = new int[grid.length];
        int[] inhabitantColumnCount = new int[grid[0].length];
        
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) {
                    inhabitantRowCount[i]++;
                    inhabitantColumnCount[j]++;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1 && 
                    (inhabitantRowCount[i] > 1 || inhabitantColumnCount[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}

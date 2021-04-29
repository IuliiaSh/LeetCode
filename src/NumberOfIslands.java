import java.util.Stack;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        int result = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        Stack<Pair> stack = new Stack<Pair>();
        Pair pair;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    result++;
                    stack.push(new Pair(i, j));
                    isVisited[i][j] = true;
                    while (!stack.isEmpty()) {
                        pair = stack.pop();
                        if (checkInGrid(grid, pair.i - 1, pair.j) && grid[pair.i - 1][pair.j] == '1' && 
                            !isVisited[pair.i - 1][pair.j]) {
                            stack.push(new Pair(pair.i - 1, pair.j));
                            isVisited[pair.i - 1][pair.j] = true;
                        }
                        if (checkInGrid(grid, pair.i + 1, pair.j) && grid[pair.i + 1][pair.j] == '1' && 
                            !isVisited[pair.i + 1][pair.j]) {
                            stack.push(new Pair(pair.i + 1, pair.j));
                            isVisited[pair.i + 1][pair.j] = true;
                        }
                        if (checkInGrid(grid, pair.i, pair.j - 1) && grid[pair.i][pair.j - 1] == '1' && 
                            !isVisited[pair.i][pair.j - 1]) {
                            stack.push(new Pair(pair.i, pair.j - 1));
                            isVisited[pair.i][pair.j - 1] = true;
                        }
                        if (checkInGrid(grid, pair.i, pair.j + 1) && grid[pair.i][pair.j + 1] == '1' && 
                            !isVisited[pair.i][pair.j + 1]) {
                            stack.push(new Pair(pair.i, pair.j + 1));
                            isVisited[pair.i][pair.j + 1] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean checkInGrid(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) return false;
        return true;
    }
}

class Pair {
    int i;
    int j;
    
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
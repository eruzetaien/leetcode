class Solution {
    public int numEnclaves(int[][] grid) {
     if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int enclavesCount = dfs(grid, i, j);
                    if (enclavesCount > 0){
                        count += enclavesCount;
                    }
                }
            }
        }
        
        return count;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return -1;
        }

        if ( grid[i][j] == -2 || grid[i][j] == 0){
            return 0;
        }
        
        grid[i][j] = -2; // visited
        
        int bottomCount  = dfs(grid, i + 1, j);
        int topCount = dfs(grid, i - 1, j);
        int rightCount = dfs(grid, i, j + 1);
        int leftCount = dfs(grid, i, j - 1);

        if (bottomCount == -1 || topCount == -1 || rightCount == -1 || leftCount == -1){
            return -1;
        }

        return 1 + bottomCount + topCount + rightCount + leftCount;
    }
}
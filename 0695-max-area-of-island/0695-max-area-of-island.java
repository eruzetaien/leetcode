class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return 0;
        }
        
        if (grid[i][j] == 0 || grid[i][j] == -1) {
            return 0;
        }
        
        // Mark as visited
        grid[i][j] = -1;
        
        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        
        return 1 + up + down + left + right;
    }
}
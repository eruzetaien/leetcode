class Solution {
        public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int closedIslands = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }
    
    private boolean dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // If we reach the boundary, island is not closed
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        
        // If it's water, it's fine (closed in this direction)
        if (grid[i][j] == 1) {
            return true;
        }
        
        // Mark as visited
        grid[i][j] = 1;
        
        // Check all 4 directions
        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        
        // Island is closed only if all directions are closed
        return up && down && left && right;
    }

}
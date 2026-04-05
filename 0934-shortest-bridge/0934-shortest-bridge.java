class Solution {
    int[][] directions = {
            {-1, 0}, // UP
            {1, 0},  // DOWN
            {0, -1}, // LEFT
            {0, 1}   // RIGHT
        };


    public int shortestBridge(int[][] grid) {
        int n = grid.length; 

        List<int[]> island1 = new ArrayList<>();
        boolean foundFirstIsland = false;

        for (int i = 0; i < n; i++) {
            if (foundFirstIsland) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, island1);
                    foundFirstIsland = true;
                    break;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] cell : island1) {
            int x = cell[0];
            int y = cell[1];
            for (int[] dir : directions){
                int nx = dir[0] + x; 
                int ny = dir[1] + y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                if (grid[nx][ny] == 0){
                    grid[x][y] = -2; // Starting island 
                    queue.add(new int[]{x,y,0});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] coordinate = queue.remove();
            int x = coordinate[0];
            int y = coordinate[1];
            int step = coordinate[2];

            if (grid[x][y] == -1){
                continue; 
            } 

            grid[x][y] = -1; // visited

            for (int[] dir : directions){
                int[] nextCoor = {dir[0] + x, dir[1] + y, step+1};
                if (nextCoor[0] < 0 || nextCoor[0] >= n || nextCoor[1] < 0 || nextCoor[1] >= n)
                    continue;

                if(grid[nextCoor[0]][nextCoor[1]] == 1){
                    return step;
                } else if (grid[nextCoor[0]][nextCoor[1]] != -1) {
                    queue.add(nextCoor);
                }
            }
        }

        return -1;
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> island1) {
        int n = grid.length;
        grid[i][j] = -1;
        island1.add(new int[]{i, j});

        for (int[] dir : directions){
            int ni = dir[0] + i; 
            int nj = dir[1] + j;
            if (ni < 0 || ni >= n || nj < 0 || nj >= n)
                continue;

            if (grid[ni][nj] == 1)
                dfs(grid, ni, nj, island1);
        }
    }
}
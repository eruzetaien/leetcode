class Solution {
    public void gameOfLife(int[][] board) {
        // Encoding
        // 0 -> 0 = 0
        // 1 -> 1 = 1
        // 1 -> 0 = 2
        // 0 -> 1 = 3

        int m = board.length;
        int n = board[0].length;

        // Directions for 8 neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0},  {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int ni = i + dir[0], nj = j + dir[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            liveNeighbors++;
                        }
                    }
                }

                // Apply rules
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // live → dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead → live
                    }
                }
            }
        }

        // Finalize the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
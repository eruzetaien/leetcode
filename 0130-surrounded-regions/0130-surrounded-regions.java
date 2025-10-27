class Solution {
    public void solve(char[][] board) {
     if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Mark Safe (S) Area
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);        // left border
            dfs(board, i, n - 1, m, n);    // right border
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, m, n);        // top border
            dfs(board, m - 1, j, m, n);    // bottom border
        }

        // Flip all remaining 'O' to 'X', and 'S' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // captured region
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';  // safe region
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;

        board[i][j] = 'S'; 

        dfs(board, i + 1, j, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i, j - 1, m, n);
    }
}
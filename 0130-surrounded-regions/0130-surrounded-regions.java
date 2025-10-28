class Solution {
    char[][] board;
    int totalRow;
    int totalCol;
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        this.board = board;
        this.totalRow = board.length;
        this.totalCol = board[0].length;

        for (int i = 0; i < totalRow; i++){
            bfs(i, 0); // first row
            bfs(i, totalCol -1); // last row
        }

        for (int j = 0; j < totalCol; j++){
            bfs(0, j);
            bfs(totalRow -1, j);
        }

        for (int i = 0; i < totalRow; i++){
            for (int j = 0; j < totalCol; j++){
                switch (this.board[i][j]){
                    case 'S':
                        this.board[i][j] = 'O';
                        break;
                    case 'O':
                        this.board[i][j] = 'X';
                        break;
                }
            }
        }
    }

    private void bfs( int i, int j){
        if (i < 0 || j < 0 || i >= this.totalRow || j >= this.totalCol )
            return;
        
        if (this.board[i][j] != 'O')
            return;
        
        this.board[i][j] = 'S';

        bfs(i + 1, j);
        bfs(i - 1, j);
        bfs(i, j + 1);
        bfs(i, j - 1);
    }


}
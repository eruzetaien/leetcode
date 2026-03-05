class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        board = [[""] * 3 for _ in range(3)]

        for i, (r, c) in enumerate(moves):
            board[r][c] = "X" if i % 2 == 0 else "O"

        def check(player):
            # rows and columns
            for i in range(3):
                if all(board[i][j] == player for j in range(3)):
                    return True
                if all(board[j][i] == player for j in range(3)):
                    return True
            
            # diagonals
            if all(board[i][i] == player for i in range(3)):
                return True
            if all(board[i][2-i] == player for i in range(3)):
                return True
            
            return False

        if check("X"):
            return "A"
        if check("O"):
            return "B"

        return "Draw" if len(moves) == 9 else "Pending"
            
            


class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        int[] board1D = new int[n * n + 1];
        Arrays.fill(board1D,-1);

        boolean isLeftToRight = true;
        int index = 1;
        for (int r = n-1; r >= 0; r--){
            if (isLeftToRight){
                for (int c = 0; c < n; c++ ){
                    board1D[index++] = board[r][c];
                }
            } else {
                for (int c = n-1; c >= 0; c--){
                    board1D[index++] = board[r][c];
                }
            }
            isLeftToRight = !isLeftToRight;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // start
        visited.add(1);
        
        int diceCount = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currPos = queue.poll();

                // System.out.println(currPos);

                if (currPos == n*n) 
                    return diceCount;

                for (int nextPos = currPos + 1; nextPos <= Math.min(currPos + 6, n*n); nextPos++){
                    int destination = (board1D[nextPos] != -1) ? board1D[nextPos] : nextPos;
                        if (!visited.contains(destination)) {
                            visited.add(destination);
                            queue.offer(destination);
                        }
                }
            }

            diceCount++;
        }
        return -1;
    }
}
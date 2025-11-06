class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] moves = new int[n * n + 1];
        Arrays.fill(moves, -1);

        // Convert 2D board to 1D moves array
        boolean leftToRight = true;
        int index = 1;
        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    moves[index++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    moves[index++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return steps; // reached last square

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int dest = (moves[next] == -1) ? next : moves[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
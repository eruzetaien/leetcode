class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startRow = -1, startCol = -1;
        int totalKeys = 0;

        // 1. Find the starting point and count total keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }

        // The bitmask we need to reach (e.g., 3 keys = 111 in binary = 7)
        int targetMask = (1 << totalKeys) - 1;
        
        // BFS Setup: Queue stores [row, col, current_mask, steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, 0, 0});

        // Visited array: visited[row][col][mask]
        boolean[][][] visited = new boolean[m][n][1 << totalKeys];
        visited[startRow][startCol][0] = true;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int dist = curr[3];

            // If we found all keys, return distance
            if (mask == targetMask) return dist;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // Boundary and Wall check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = grid[nr].charAt(nc);
                if (cell == '#') continue;

                int nextMask = mask;

                // If it's a lock, check if we have the key
                if (cell >= 'A' && cell <= 'F') {
                    if ((mask & (1 << (cell - 'A'))) == 0) continue;
                }

                // If it's a key, update our mask
                if (cell >= 'a' && cell <= 'f') {
                    nextMask |= (1 << (cell - 'a'));
                }

                // If this state (position + keys held) hasn't been visited
                if (!visited[nr][nc][nextMask]) {
                    visited[nr][nc][nextMask] = true;
                    queue.offer(new int[]{nr, nc, nextMask, dist + 1});
                }
            }
        }

        return -1;
    }
}
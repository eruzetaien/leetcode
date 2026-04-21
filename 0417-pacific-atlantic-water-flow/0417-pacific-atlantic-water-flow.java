class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        // Visited sets for Pacific and Atlantic
        Set<String> pacificVisited = new HashSet<>();
        Set<String> atlanticVisited = new HashSet<>();
        
        // Perform BFS from the Pacific Ocean (top and left edges)
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0}); // Pacific Ocean queue
            atlanticQueue.offer(new int[]{i, n - 1});
        }
        
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j}); // Pacific Ocean queue
            atlanticQueue.offer(new int[]{m - 1, j});
        }
        
        // BFS for Pacific Ocean
        while (!pacificQueue.isEmpty()) {
            int[] cell = pacificQueue.poll();
            int row = cell[0], col = cell[1];
            if (pacificVisited.contains(row + "," + col)) continue;
            pacificVisited.add(row + "," + col);
            
            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                    && !pacificVisited.contains(newRow + "," + newCol)
                    && heights[newRow][newCol] >= heights[row][col]
                ) {
                    pacificQueue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // BFS for Atlantic Ocean
        while (!atlanticQueue.isEmpty()) {
            int[] cell = atlanticQueue.poll();
            int row = cell[0], col = cell[1];
            if (atlanticVisited.contains(row + "," + col)) continue;
            atlanticVisited.add(row + "," + col);
            
            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                    && !atlanticVisited.contains(newRow + "," + newCol) 
                    && heights[newRow][newCol] >= heights[row][col]
                ) {
                    atlanticQueue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // Find the intersection of both sets
        for (String cell : pacificVisited) {
            if (atlanticVisited.contains(cell)) {
                String[] coordinates = cell.split(",");
                List<Integer> coordinateList = new ArrayList<>();
                coordinateList.add(Integer.parseInt(coordinates[0]));
                coordinateList.add(Integer.parseInt(coordinates[1]));
                result.add(coordinateList);
            }
        }
        
        return result;
    }

}
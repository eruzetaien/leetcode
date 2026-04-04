class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; 
        int n = maze[0].length; 
        Queue<int[]> queue = new LinkedList<>();
        int[] startCoor = {entrance[0], entrance[1], 0};
        queue.add(startCoor);

        int[][] directions = {
            {-1, 0}, // UP
            {1, 0},  // DOWN
            {0, -1}, // LEFT
            {0, 1}   // RIGHT
        };

        while (!queue.isEmpty()){
            int[] coordinate = queue.remove();
            int x = coordinate[0];
            int y = coordinate[1];
            int step = coordinate[2];

            System.out.println(Arrays.toString(coordinate));
            
            if (maze[x][y] == '-'){
                continue; // visited
            }

            maze[x][y] = '-';

            if (!(x == entrance[0] && y == entrance[1]) && (x == 0 || y == 0 || x == m-1 || y == n-1)){
                return step;
            }

            for (int[] dir : directions){
                int[] nextCoor = {dir[0] + x, dir[1] + y, step+1};
                if (nextCoor[0] < 0 || nextCoor[0] >= m || nextCoor[1] < 0 || nextCoor[1] >= n)
                    continue;

                if (maze[nextCoor[0]][nextCoor[1]] == '.'){
                    queue.add(nextCoor);
                }
            }
        }


        return -1;
    }

}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] right = new int[]{0,1}; 
        int[] left = new int[]{0,-1}; 
        int[] up = new int[]{-1,0}; 
        int[] down = new int[]{1,0}; 

        int[][] directions = new int[][]{right, down, left, up};
        int pointerDir = 0;

        List<Integer> result = new ArrayList<>();

        int total = m * n;
        int count = 0;
        int visited = -101;
        int i = 0, j = 0;
        while (count < total){
            result.add(matrix[i][j]);
            matrix[i][j] = visited;
            count++;
            
            // Update
            int nextRow = i + directions[pointerDir][0];
            int nextCol = j + directions[pointerDir][1];

            if (nextRow >= m || nextCol >= n || nextCol < 0 ||
                matrix[nextRow][nextCol] == visited) 
            {
                pointerDir = (pointerDir + 1) % directions.length;
            }
            i += directions[pointerDir][0];
            j += directions[pointerDir][1];
        }

        return result;
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length; // col

        int[] dp = new int[n];
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] == 1){break;}
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++){
            // System.out.println(Arrays.toString(dp));
            if (obstacleGrid[i][0] == 1){ dp[0] = 0}
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j]== 1){
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
            // System.out.println("=======");
        }


        return dp[n-1];
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int [][] dp = new int[m+1][n+1];

        for (int i = 0; i<= m; i++ ){dp[i][0] = i;}
        for (int j = 0; j<= n; j++ ){dp[0][j] = j;}

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int insertCost = 1;
                int deleteCost =1;
                int replaceCost = 0;
                if (word1.charAt(i-1) != word2.charAt(j-1)){ replaceCost = 1;}
                
                int totalInsertCost = dp[i][j-1] + insertCost;
                int totalDeleteCost = dp[i-1][j] + deleteCost;
                int totalReplaceCost = dp[i-1][j-1] + replaceCost;

                int minCost = totalReplaceCost;
                if (totalInsertCost < minCost){minCost = totalInsertCost;}
                if (totalDeleteCost < minCost){minCost = totalDeleteCost;}
                
                dp[i][j] = minCost;
            }
        }

        return dp[m][n];
    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Only one way to reach any cell in the first row

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];  // Update number of ways to reach current cell
            }
        }

        return dp[n - 1];
    }
}
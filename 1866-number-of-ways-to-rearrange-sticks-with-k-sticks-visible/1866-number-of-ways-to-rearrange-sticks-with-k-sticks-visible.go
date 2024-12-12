func rearrangeSticks(n int, k int) int {
    MOD := int(1e9 + 7)
    dp := make([][]int, n+1)
    for i := range dp {
        dp[i] = make([]int, k+1)
    }

    // Base case
    dp[0][0] = 1

    for i := 1; i <= n; i++ {
        for j := 1; j <= k; j++ {
            // Case 1: Last Stick visible
            case1 := dp[i-1][j-1]
            
            // Case 2: Last stick not visible
            case2 := (i-1) * dp[i-1][j]
            
            dp[i][j] = (case1 + case2) % MOD
        }
    }

    return dp[n][k]
}
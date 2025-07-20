class Solution {
    public int uniquePaths(int m, int n) {
        // Combination to chose all dowm move or right move needed from total move
        int N = m -1 + n - 1;
        int k = Math.min(m - 1, n - 1); // Choose smaller to optimize
        long result = 1;

        for (int i = 1; i <= k; i++) {
            result = result * (N - k + i) / i;
        }

        return (int) result;
    }
}
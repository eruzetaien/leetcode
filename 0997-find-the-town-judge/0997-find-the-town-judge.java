class Solution {
    public int findJudge(int n, int[][] trust) {
        // We use n + 1 to accommodate 1-based indexing for people
        int[] netTrustScore = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0]; // truster
            int b = t[1]; // trustee

            // Person 'a' trusts someone: their potential to be judge decreases
            netTrustScore[a]--;

            // Person 'b' is trusted: their potential to be judge increases
            netTrustScore[b]++;
        }

        for (int i = 1; i <= n; i++) {
            // The judge must be trusted by (n-1) people and trust 0 people
            // (n-1) - 0 = n-1
            if (netTrustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
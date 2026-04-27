class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Set<String> roadsSet = new HashSet<>();
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            degree[a]++;
            degree[b]++;
            
            roadsSet.add(a + "," + b);
            roadsSet.add(b + "," + a);
        }
        
        int maxRank = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currentRank = degree[i] + degree[j];
                
                if (roadsSet.contains(i + "," + j)) {
                    currentRank--;
                }
                
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        
        return maxRank;
    }
}
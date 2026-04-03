class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] disc = new int[n];  // discovery times
        int[] low = new int[n];   // low-link values
        Arrays.fill(disc, -1);
        
        List<List<Integer>> res = new ArrayList<>();
        int[] time = new int[1]; // mutable time
        
        dfs(0, -1, graph, disc, low, time, res);
        
        return res;
    }
    
    private void dfs(int u, int parent, List<List<Integer>> graph,
                     int[] disc, int[] low, int[] time,
                     List<List<Integer>> res) {
        
        disc[u] = low[u] = time[0]++;
        
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            
            if (disc[v] == -1) {
                dfs(v, u, graph, disc, low, time, res);
                low[u] = Math.min(low[u], low[v]);
                
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
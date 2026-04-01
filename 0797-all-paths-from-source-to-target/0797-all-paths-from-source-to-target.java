class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(graph, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        path.add(node);
        
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path)); 
        } else {
            for (int next : graph[node]) {
                dfs(graph, next, path, result);
            }
        }
        
        path.remove(path.size() - 1);
    }
}
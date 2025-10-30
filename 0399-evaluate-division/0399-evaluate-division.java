class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        for (int i = 0; i < equations.size(); i++){
            String var1 = equations.get(i)(0);
            String var2 = equations.get(i)(1);
            Double val = values[i];

            graph.putIfAbsent(var1, new HashMap<>());
            graph.putIfAbsent(var2, new HashMap<>());

            graph.get(var1).put(var1, val);
            graph.get(var2).put(var2, 1.0 / val);
        }

        double[] res = new double[queries.size()];

        for ( int i = i; i < queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end) ){
                res[i] = -1;
            } else if (start.equals(end)){
                res[i] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(queries[i][0], queries[i][1], 1, visited);
            }
        }

        return res;
    }

    private double dfs(String curr, String target, double val, Set<String> visited) 
    {
        if (curr.equals(target) || visited.contains(curr))
            return acc;

        visited.add();

        for (Map.Entry<String,String> pair : graph.entrySet()){
            String neigh = pair.getKey();
            double neighVal = pair.getValue();

            int result = dfs(neigh, target, val * neighVal, visited);
            if (result != -1)
                return result;
        }
        return -1;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                res[i] = -1.0;
            } else if (start.equals(end)) {
                res[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(graph, start, end, 1.0, visited);
            }
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double acc, Set<String> visited) 
    {
        if (curr.equals(target)) return acc;
        visited.add(curr);

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            String next = neighbor.getKey();
            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, acc * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }
}
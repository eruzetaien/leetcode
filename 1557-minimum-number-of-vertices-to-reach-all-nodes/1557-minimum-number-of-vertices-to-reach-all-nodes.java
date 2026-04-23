class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegreeCount = new int[n];

        for (List<Integer> edge : edges) {
            inDegreeCount[edge.get(1)] += 1; 
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if (inDegreeCount[i] == 0 ){
                result.add(i);
            }
        }

        return result;
    }
}
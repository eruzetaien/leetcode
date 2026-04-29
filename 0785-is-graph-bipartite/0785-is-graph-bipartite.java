class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // -1 means unvisited, 0 = set A, 1 = set B
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        // We need to handle disconnected components
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) { // unvisited
                if (!bfsCheck(graph, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int[][] graph, int start, int[] colors) {
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(start, true)); // start with set A
        colors[start] = 0; // 0 represents set A

        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            int currentNode = current.node;
            boolean currentSet = current.setFlag;
            int currentColor = currentSet ? 0 : 1;

            for (int neighbor : graph[currentNode]) {
                if (colors[neighbor] == -1) {
                    // Assign the neighbor to the opposite set
                    colors[neighbor] = 1 - currentColor;
                    queue.add(new NodeInfo(neighbor, !currentSet));
                } else if (colors[neighbor] == currentColor) {
                    // Contradiction: neighbor has same color as current node
                    return false;
                }
            }
        }
        return true;
    }

    class NodeInfo {
        int node;
        boolean setFlag; // true for set A, false for set B

        NodeInfo(int node, boolean setFlag) {
            this.node = node;
            this.setFlag = setFlag;
        }
    }
}
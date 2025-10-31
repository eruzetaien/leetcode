class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build in-degree array
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 3: Add all courses with in-degree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: Process nodes in topological order
        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;

            for (int next : graph.get(course)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Step 5: Check if we completed all courses
        return completed == numCourses;
    }
}
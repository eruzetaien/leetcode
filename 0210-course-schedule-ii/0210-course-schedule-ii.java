class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegreeCount = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[1];
            int course = prerequisite[0];
            graph.get(preCourse).add(course);
            inDegreeCount[course]++;
        }

        Queue<Integer> courseQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegreeCount[i] == 0) {
                courseQueue.offer(i);
            }
        }

        // Perform topological sort (BFS)
        int[] order = new int[numCourses];
        int index = 0;

        while (!courseQueue.isEmpty()) {
            int course = courseQueue.poll();
            order[index++] = course;
            

            for (int nextCourse : graph.get(course)) {
                if (--inDegreeCount[nextCourse] == 0) {
                    courseQueue.offer(nextCourse);
                }
            }
        }

        // If we couldn't take all courses, there's a cycle
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}
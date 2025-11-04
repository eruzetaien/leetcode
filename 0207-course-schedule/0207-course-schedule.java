class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] inDegreeCount = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
    
        for (int[] prerequisite : prerequisites){
            int preCourse = prerequisite[1];
            int course = prerequisite[0];

            graph.get(preCourse).add(course);
            inDegreeCount[course] += 1;
        }
        
        Queue<Integer> availableCourse = new LinkedList<>();
        for (int i = 0; i < numCourses ; i++ ){
            if (inDegreeCount[i] == 0)
                availableCourse.offer(i);
        }

        int completed = 0;
        while (!availableCourse.isEmpty()){
            int course = availableCourse.poll();
            completed++;

            for (int nextCourse : graph.get(course) ){
                if (--inDegreeCount[nextCourse] == 0)
                    availableCourse.offer(nextCourse);
            }
        }

        System.out.println(Arrays.toString(inDegreeCount));
        System.out.println(graph);

        return numCourses == completed;
    }
}
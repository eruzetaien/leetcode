class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 0;

        Arrays.sort(points, (a, b) -> {
            int cmp = Integer.compare(a[0], b[0]);  
            if (cmp == 0) {
                return Integer.compare(a[1], b[1]); 
            }
            return cmp;
        });

        System.out.println(Arrays.deepToString(points));

        int currentEnd = points[0][1];
        count++;
        for (int[] point : points){
            if (point[0] <= currentEnd){
                currentEnd = Math.min(currentEnd, point[1]);
            } else {
                count++;
                currentEnd = point[1];
            }
        }
        return count;
    }
}
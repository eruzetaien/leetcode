class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Set<Integer> visited = new HashSet<>();
        

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int index = queue.poll();

            System.out.println(index);

            if (arr[index] == 0)
                return true;

            visited.add(index);
            int forwardNextIndex = index + arr[index];
            if (!visited.contains(forwardNextIndex) && forwardNextIndex >= 0 && forwardNextIndex < n)
                queue.offer(forwardNextIndex);

            int backwardNextIndex = index - arr[index];
            if (!visited.contains(backwardNextIndex) && backwardNextIndex >= 0 && backwardNextIndex < n)
                queue.offer(backwardNextIndex);
        }
        return false;
    }
}
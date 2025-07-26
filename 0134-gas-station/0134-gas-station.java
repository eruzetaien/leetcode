class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        int[] diff = new int[n];
        int totalDiff = 0;
        for (int i = 0; i<n; i++){
            diff[i] = gas[i] - cost[i];
            totalDiff += diff[i];
        }

        if (totalDiff < 0) {return -1;}

        int startIdx = -1;
        totalDiff = 0;
        for (int i = 0; i<n; i++){
            totalDiff += diff[i];

            if (totalDiff < 0){ 
                startIdx = -1;
                totalDiff = 0;
            } else if (startIdx == -1){
                startIdx = i;
            }
        }
        // System.out.println(Arrays.toString(diff));
        // System.out.println(totalDiff);

        return startIdx; 
    }
}
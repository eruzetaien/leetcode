class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {return 0;}
        
        int prevReachable = -1;
        int prevJumpCount = 0;
        
        int maxReachable = nums[0];
        int maxJumpCount = prevJumpCount + 1;

        int i = 1;
        while (i < n && maxReachable < n-1){
            if (i > prevReachable){
                prevReachable = maxReachable;
                prevJumpCount = maxJumpCount;
            }

            if (i + nums[i] > maxReachable){
                maxReachable = i + nums[i];
                maxJumpCount = prevJumpCount + 1;
            }
            System.out.print(i);
            System.out.println(" =======");
            System.out.println(prevReachable);
            System.out.println(prevJumpCount);
            System.out.println(maxReachable);
            System.out.println(maxJumpCount);
            System.out.println();
            i++;

        }
        return maxJumpCount;
    }
}
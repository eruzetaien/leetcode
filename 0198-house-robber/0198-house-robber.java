class Solution {
    public int rob(int[] nums) {
        Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
        return helper(nums, 0, memo);
    }

    private int helper(int[] nums, int idx, Map<Integer, Integer> memo){
        if (idx >= nums.length){return 0;}

        int rob1 = nums[idx];
        if (memo.containsKey(idx+2)){rob1 += memo.get(idx+2);}
        else {rob1 += helper(nums, idx+2, memo); }

        if (idx+1  >= nums.length){
            memo.put(idx, rob1);
            return rob1;
        }

        int rob2 = nums[idx+1];
        if (memo.containsKey(idx+3)){rob2 += memo.get(idx+3);}
        else {rob2 += helper(nums, idx+3, memo); }

        memo.put(idx, Math.max(rob1, rob2));
        return memo.get(idx);
    }
}
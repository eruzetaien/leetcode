class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (diff.containsKey(num)){
                return new int[]{diff.get(num), i};
            }
            diff.put(target - num, i);
        }
        return new int[2];
    }
}
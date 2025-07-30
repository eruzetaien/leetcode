class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> output = new HashSet<>();
        for (int i = 0; i < n -2; i++){
            
            int midPointer = i + 1;
            int rightPointer = n - 1;

            while (midPointer < rightPointer){
                int sum = nums[i] + nums[midPointer] + nums[rightPointer];
                if (sum == 0){
                    output.add(Arrays.asList(nums[i], nums[midPointer], nums[rightPointer]));
                    midPointer++;
                    rightPointer--;
                } else if (sum < 0){
                    midPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return new ArrayList<>(output);
    }
}
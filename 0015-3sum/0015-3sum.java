class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < n -2; i++){
            if (i > 0 && nums[i] == nums[i-1]){continue;}

            int midPointer = i + 1;
            int rightPointer = n - 1;

            while (midPointer < rightPointer){
                int sum = nums[i] + nums[midPointer] + nums[rightPointer];
                if (sum == 0){
                    output.add(Arrays.asList(nums[i], nums[midPointer], nums[rightPointer]));

                    // Skip duplicate nums[midPointer]
                    while (midPointer < rightPointer && nums[midPointer] == nums[midPointer + 1]) midPointer++;
                    // Skip duplicate nums[rightPointer]
                    while (midPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) rightPointer--;

                    midPointer++;
                    rightPointer--;
                } else if (sum < 0){
                    midPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return output;
    }
}
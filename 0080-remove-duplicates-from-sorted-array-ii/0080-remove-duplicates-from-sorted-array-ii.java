class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> occurrenceMap = new HashMap<Integer, Integer>();
        
        int i = 0;
        occurrenceMap.put(nums[i], 1);

        for (int j = 1; j < nums.length; j++ ){
            occurrenceMap.put(nums[j], occurrenceMap.getOrDefault(nums[j], 0) + 1);
            if (nums[j] != nums[i] || occurrenceMap.get(nums[i]) <= 2){
                i++;
                nums[i] = nums[j];
            } 
        }

        return i + 1;
    }
}
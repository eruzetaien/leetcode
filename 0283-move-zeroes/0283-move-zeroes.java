class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        int nonZeroPointer = 0;

        while(nonZeroPointer < nums.length){
            if (nums[zeroPointer] == 0 && nums[nonZeroPointer] != 0){
                nums[zeroPointer] = nums[nonZeroPointer];
                nums[nonZeroPointer] = 0;
            } 
            if (nums[zeroPointer] != 0)
                zeroPointer++;

            nonZeroPointer++;
        }
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1){
            return (nums[0] == val) ? 0 : 1;
        }

        int k = 0;
        int frontPointer = 0;
        int backPointer = nums.length-1;

        while(
            frontPointer < nums.length && 
            backPointer > 0 && 
            frontPointer <= backPointer
        ) {
            int frontNum = nums[frontPointer];
            if (frontNum == val){
                int backNum = nums[backPointer];
                if (backNum != val){
                    nums[frontPointer] = backNum;
                    nums[backPointer] = frontNum;
                    k++;
                    frontPointer++;
                } 
                backPointer--;
            } else {
                k++;
                frontPointer++;
            }
        }
        return k;
    }
}
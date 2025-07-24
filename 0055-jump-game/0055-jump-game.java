class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1){return true;}

        int jumpPower = nums[0];
        int pointer = 0;

        while (jumpPower > 0 && pointer < n-1) {
            jumpPower--;
            pointer++;
            if (nums[pointer] > jumpPower){
                jumpPower = nums[pointer];
            }
        }

        return pointer == n - 1;
    }
}
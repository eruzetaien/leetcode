class Solution {
    public int majorityElement(int[] nums) {
        int majorityBound = nums.length / 2;
        int candidate = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
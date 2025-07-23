class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int numOfIterations = gcd(n,k);

        for (int i = 0; i < numOfIterations; i++){
            int startIdx = i;
            int pointer = startIdx;
            int temp = nums[pointer];
            do {
                int num = temp;
                int newIdx = (pointer + k) % n;
                temp = nums[newIdx];
                nums[newIdx] = num;

                pointer = newIdx;
            } while (pointer != startIdx);
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
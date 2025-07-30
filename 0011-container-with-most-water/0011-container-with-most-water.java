class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int leftPointer = 0;
        int rightPointer = n-1;

        int maxWater = 0;
        while (leftPointer < rightPointer){
            int waterAmount = (rightPointer - leftPointer);

            int minHeight = 0;
            if (height[leftPointer] < height[rightPointer]){
                minHeight = height[leftPointer];
                leftPointer++;
            } else {
                minHeight = height[rightPointer];
                rightPointer--;
            }
            waterAmount *= minHeight;

            maxWater = Math.max(maxWater, waterAmount);
        }

        return maxWater;

    }
}
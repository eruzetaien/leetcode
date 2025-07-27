class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] highestLeftBar = new int[n];
        int[] highestRightBar = new int[n];

        // int maxHeight = 0;
        highestLeftBar[0] = height[0];
        for (int i = 1; i < n; i++){
            if (height[i] > highestLeftBar[i-1]){
                highestLeftBar[i] = height[i];
            } else {
                highestLeftBar[i] = highestLeftBar[i-1];
            }
        }

        highestRightBar[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--){
            if (height[i] > highestRightBar[i+1]){
                highestRightBar[i] = height[i];
            } else {
                highestRightBar[i] = highestRightBar[i+1];
            }
        }

        int totalWater = 0;

        for (int i = 0; i < n; i++){
            totalWater += Math.min(highestLeftBar[i], highestRightBar[i]) - height[i];
        }

        // System.out.println(Arrays.toString(highestLeftBar));
        // System.out.println(Arrays.toString(highestRightBar));

        return totalWater;

    }
}
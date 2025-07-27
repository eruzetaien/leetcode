class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int total = n;

        int[] additionalCandies = new int[n];
        
        // Left to Right
        additionalCandies[0] = 0;
        for (int i = 1; i < n; i++){
            if (ratings[i] > ratings[i-1]){
                additionalCandies[i] = additionalCandies[i-1] + 1;
            } 
        }

        // Right to Left
        additionalCandies[0] = 0;
        for (int i = n-2; i >= 0; i--){
            if (ratings[i] > ratings[i+1] && 
                additionalCandies[i] <= additionalCandies[i+1]
            ){
                additionalCandies[i] = additionalCandies[i+1] + 1;
            } 
        }
        for (int candy : additionalCandies ){
            total += candy;
        }
        return total;
    }
}
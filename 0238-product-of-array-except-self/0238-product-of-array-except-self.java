class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> cumProduct = new HashMap<Integer, Integer>();
        
        int product = 1;
        for (int i = 0; i<n; i++){
            product *= nums[i];
            cumProduct.put(i, product);
        }

        int[] result = new int[n];
        result[n-1] = cumProduct.get(n-2);

        product = nums[n-1];        
        for (int i = n-2; i>0; i--){
            result[i] = cumProduct.get(i-1) * product;
            product *= nums[i];
        }
        result[0] = product;

        return result;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> cumProduct = new HashMap<Integer, Integer>();
        Map<Integer, Integer> reverseCumProduct = new HashMap<Integer, Integer>();
        
        int product = 1;
        for (int i = 0; i<n; i++){
            product *= nums[i];
            cumProduct.put(i, product);
        }

        product = 1;
        for (int i = n-1; i>0; i--){
            product *= nums[i];
            reverseCumProduct.put(i, product);
        }
        
        int[] result = new int[n];
        result[0] = reverseCumProduct.get(1);
        result[n-1] = cumProduct.get(n-2);

        for (int i = 1; i<n-1; i++){
            result[i] = cumProduct.get(i-1) * reverseCumProduct.get(i+1);
        }

        return result;
    }
}
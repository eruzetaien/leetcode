class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < n; i++){
            if (map.containsKey(numbers[i])){
                return new int[] {map.get(numbers[i]) + 1, i + 1};
            }
            map.put(target - numbers[i], i);
        }

        return new int[] {-1,-1};
    }
}
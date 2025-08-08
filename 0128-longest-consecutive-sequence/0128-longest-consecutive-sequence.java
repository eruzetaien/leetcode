class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int length = left + right + 1;

                map.put(num, length);

                map.put(num - left, length);
                map.put(num + right, length);

                longest = Math.max(longest, length);
            }
        }
        return longest;

    }
}
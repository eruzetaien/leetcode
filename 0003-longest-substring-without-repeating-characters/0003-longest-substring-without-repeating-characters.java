class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;
        int startIdx = 0;
        for (int i = 0; i < n; i++){
            if (map.containsKey(s.charAt(i))){
                int nextIdx = map.get(s.charAt(i)) + 1;
                startIdx = Math.max(startIdx, nextIdx);
            } 
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - startIdx + 1);
            // System.out.println(map);
            // System.out.println(s.charAt(i));
            // System.out.println(maxLen);
            // System.out.println();
        }    


        return maxLen;
    }
}
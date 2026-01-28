class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1);    
        }

        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c))
                return c;
            
            int charCount = charCountMap.get(c);
            if (charCount <= 0)
                return c;

            charCountMap.put(c, charCount - 1);    
        }
        return Character.MIN_VALUE;
    }
}
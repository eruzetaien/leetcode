class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map <Character, Integer> charFreq = new HashMap<>();
        
        for (char ch : magazine.toCharArray()){
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()){
            if (! charFreq.containsKey(ch)){
                return false;
            }
            charFreq.put(ch, charFreq.get(ch) - 1);
            if (charFreq.get(ch) < 0){
                return false;
            }
        }

        return true;
    }
}
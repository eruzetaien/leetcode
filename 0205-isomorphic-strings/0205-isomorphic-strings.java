class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){return false;}

        // 2 map -> K,V = Char,Freq
        // Populate map -> O(max(M,N))
        // 2 List -> freq
        // Sort list  | O(Max(N Log(N),  M Log(M))
        // Compare 2 List 


        Map<Character, Integer> charSFreq = new HashMap<>();
        Map<Character, Integer> charTFreq = new HashMap<>();

        for (char ch : s.toCharArray()){
            charSFreq.put(ch, charSFreq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()){
            charTFreq.put(ch, charTFreq.getOrDefault(ch, 0) + 1);
        }

        int totalUniqueCharS = charSFreq.size();
        int totalUniqueCharT = charTFreq.size();

        if (totalUniqueCharS != totalUniqueCharT){return false;}

        int[] freqS = new int[totalUniqueCharS];
        int[] freqT = new int[totalUniqueCharT];

        Arrays.sort(freqS);
        Arrays.sort(freqT);

        for (int i = 0; i < totalUniqueCharS; i++){
            if (freqS[i] != freqT[i]){return false;}
        }

        return true;
    }
}
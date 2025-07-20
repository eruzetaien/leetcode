class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String longText;
        String shortText;

        if (text1.length() > text2.length()){
            longText = text1;
            shortText = text2;
        } else {
            longText = text2;
            shortText = text1;
        }
        Map<Character,Integer> occurrences = new HashMap<Character,Integer>();
        for (char c : shortText.toCharArray()){
            occurrences.put(c, 0);
        } 

        for (char c : longText.toCharArray()){
            if (occurrences.containsKey(c)){
                occurrences.put(c, occurrences.get(c) + 1);
            }
        }
        System.out.println(occurrences);

        int longestSubSeq = 0;
        int total = 0;
        for (char c : shortText.toCharArray()){
            if (occurrences.get(c) > 0){
                total ++;
                occurrences.put(c, occurrences.get(c) - 1);
            } else {
                if (total > longestSubSeq){longestSubSeq = total;}
                total = 0;
            }
        } 
        if (total > longestSubSeq){return total;}

        return longestSubSeq;

    }
}
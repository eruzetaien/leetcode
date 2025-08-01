class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> occurrenceFreq = new HashMap<>();

        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }

        int left = -1, right = -1, idx =0;
        int count = 0;
        int minLen = m;
        int minLeft = -1;
        while (idx < m) {
            char idxChar = s.charAt(idx);
            if (freq.containsKey(idxChar)) {
                if (minLeft == -1){minLeft = idx; left = minLeft;}
                occurrenceFreq.put(idxChar, occurrenceFreq.getOrDefault(idxChar,0) + 1);

                if (occurrenceFreq.get(idxChar) <= freq.get(idxChar)){
                    count++;
                }

                while (left < idx &&
                    occurrenceFreq.get(s.charAt(left)) > freq.get(s.charAt(left)))
                {
                    occurrenceFreq.put(s.charAt(left), occurrenceFreq.get(s.charAt(left)) - 1);
                    // if (occurrenceFreq.get(s.charAt(left) < freq.get(s.charAt(left)){
                    //     count++;
                    // }
                    // count--;

                    left++;                   
                    while (left < idx && !occurrenceFreq.containsKey(s.charAt(left)) ){
                        left++;
                    }
                }


                if (count == n ){
                    int currLen = idx - left + 1;
                    if (currLen <= minLen) {
                        right = idx;
                        minLen = currLen;
                        minLeft = left;
                    }
                } 
            }
            // System.out.println(idx);
            // System.out.println(s.substring(minLeft,right+1));
            // System.out.println();
            idx++;
        }

        if (right == -1){ return "";}
        return s.substring(minLeft,right+1);
    }
}
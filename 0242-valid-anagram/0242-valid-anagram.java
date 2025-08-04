class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){return false;}

        int[] freq = new int[26];
        for (int i = 0; i < s.length();  i++){
            char ch = s.charAt(i);
            freq[ch - 'a'] ++;
        }

        for (int i = 0; i < t.length();  i++){
            char ch = t.charAt(i);
            if (--freq[ch - 'a'] < 0){return false;}
            // System.out.println(String.format("%s : %d", ch, freq[ch-'a']));
            // System.out.println();
        }

        return true;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sCharCount = new char[26];
        char[] tCharCount = new char[26];
        
        for (char c : s.toCharArray()){
            sCharCount[c -'a'] += 1;
        }

        for (char c : t.toCharArray()){
            tCharCount[c -'a'] += 1;
        }

        return Arrays.equals(sCharCount, tCharCount);
    }
}
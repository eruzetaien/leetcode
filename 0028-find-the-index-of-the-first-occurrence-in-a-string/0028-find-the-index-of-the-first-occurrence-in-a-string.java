class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length(); 
        int needleLen = needle.length();

        if (haystackLen == needleLen){
            if (haystack.equals(needle))
                return 0;
            return -1;
        }

        for (int i = 0; i < haystackLen - needleLen; i++){
            if (haystack.substring(i, i+needleLen).equals(needle))
                return i;
        } 
        return -1;
    }
}
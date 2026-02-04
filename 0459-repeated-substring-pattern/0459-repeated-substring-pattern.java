class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n]; // longest prefix-suffix (KMP)

        int j = 0;
        int i = 1;

        while (i < n){
            if (s.charAt(i) == s.charAt(j)){
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0){
                    j = lps[j-1]; 
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int substringLen = lps[n-1];
        return substringLen > 0 && n % (n-substringLen) == 0;
    }
}
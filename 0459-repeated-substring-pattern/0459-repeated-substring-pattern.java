class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int subLen = 1; subLen <= n / 2; subLen++) {
            if (n % subLen != 0) continue;

            String pattern = s.substring(0, subLen);
            int i = subLen;

            while (i < n && s.startsWith(pattern, i)) {
                i += subLen;
            }

            if (i == n) return true;
        }

        return false;

    }
}
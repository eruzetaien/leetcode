class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){return false;}

        int[] mapST = new int[256]; // map from s to t
        int[] mapTS = new int[256]; // map from t to s

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            // if mappings are inconsistent
            if (mapST[sc] == 0 && mapTS[tc] == 0) {
                mapST[sc] = tc;
                mapTS[tc] = sc;
            } else {
                if (mapST[sc] != tc || mapTS[tc] != sc) return false;
            }
        }

        return true;
    }
}
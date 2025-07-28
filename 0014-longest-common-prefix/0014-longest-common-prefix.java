class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0){return "";}

        String shortestStr = strs[0];
        for (int i = 1; i < n; i++){
            if (strs[i].length() < shortestStr.length()){
                shortestStr = strs[i];
            }
        }

        for (int j = 0; j < shortestStr.length(); j++){
            for (int i = 0; i < n; i++){
                if (strs[i].charAt(j) != shortestStr.charAt(j)){
                    return shortestStr.substring(0, j);
                }
            }
        }
        

        return shortestStr;


        
    }
}
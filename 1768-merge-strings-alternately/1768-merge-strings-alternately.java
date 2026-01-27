class Solution {
    public String mergeAlternately(String word1, String word2) {
        int ptr1 = 0;
        int ptr2 = 0;

        String mergedResult = "";
        boolean isAddWord1 = true;
        while (ptr1 < word1.length() && ptr2 < word2.length()){
            if (isAddWord1){
                mergedResult += word1.charAt(ptr1);
                ptr1++;
            }
            else{
                mergedResult += word2.charAt(ptr2);
                ptr2++;
            }
            isAddWord1 = !isAddWord1;
        }

        while (ptr1 < word1.length()){
            mergedResult += word1.charAt(ptr1);
            ptr1++;
        }

        while (ptr2 < word2.length()){
            mergedResult += word2.charAt(ptr2);
            ptr2++;
        }

        return mergedResult;
    }
}
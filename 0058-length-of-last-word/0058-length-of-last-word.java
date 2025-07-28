class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        int n = s.length();
        int lastWordLength = 0;

        int pointer = n-1;
        while (pointer >= 0 && s.charAt(pointer) != ' '){
            lastWordLength++;
            pointer--;
        }

        return lastWordLength;
    }
}
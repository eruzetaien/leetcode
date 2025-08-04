class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        if (pattern.length() != words.length){return false;}

        Map<String, Character> wordToChar = new HashMap<>();
        Map<Character, String> charToWord = new HashMap<>();

        for (int i = 0; i < words.length;  i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) return false;
            } else {
                wordToChar.put(word, ch);
            }

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) return false;
            } else {
                charToWord.put(ch, word);
            }
        }

        return true;
    }
}
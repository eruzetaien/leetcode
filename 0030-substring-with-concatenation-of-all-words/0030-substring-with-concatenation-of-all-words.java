class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int permutationLen = wordLen * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, Integer> windowCount = new HashMap<>();

        for (String word : words){
            wordCount.put(word, wordCount.getOrDefault(word,0) + 1);
        }

        // Offset e.g wordLen == 2 => 0,2,4,... & 1,3,5,...
        for (int i = 0; i < wordLen; i++){
            int left = i;
            int right = i;
            int count = 0;
            
            while (right + wordLen <= s.length()){
                String word = s.substring(right, right + wordLen);
                
                if (wordCount.containsKey(word)){
                    windowCount.put(word, windowCount.getOrDefault(word,0) + 1);
                    count += wordLen;

                    while (windowCount.get(word) > wordCount.get(word)){
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        left += wordLen;
                        count -= wordLen;
                    }

                    if (count == permutationLen){
                        result.add(left);
                    }
                    
                } else {
                    windowCount.clear();
                    count = 0;
                    left = right + wordLen;
                }

                System.out.println(word);
                System.out.println(count);
                System.out.println();
                right += wordLen;
            }
        }

        

        return result;
    }
}
class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = visited.get(word);

            if (word.equals(endWord)) {
                return steps;
            }

            for (String nextWord : wordSet) {
                if (!visited.containsKey(nextWord) && isOneLetterDiff(word, nextWord)) {
                    visited.put(nextWord, steps + 1);
                    queue.add(nextWord);
                }
            }
        }
        
        return 0;
    }

    private boolean isOneLetterDiff(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
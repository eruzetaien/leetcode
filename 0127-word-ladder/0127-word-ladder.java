class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Preprocessing step
        Map<String, List<String>> patternMap = new HashMap<>();
        int wordLen = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int level = current.getValue();

            for (int i = 0; i < wordLen; i++) {
                String pattern = word.substring(0, i) + '*' + word.substring(i + 1);

                List<String> nextWords = patternMap.getOrDefault(pattern, Collections.emptyList());
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) return level + 1;
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(new Pair<>(nextWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
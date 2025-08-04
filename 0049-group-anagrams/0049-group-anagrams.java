class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map : Key = Set, Value = List<String>
        // For loop -> string | O(N), N = jumlah string
        //    sorting -> Anagram | O(M log (M)), M = jumlah karakter dalam string
        //

        Map<String, List<String> > anagramMap = new HashMap<>();

        for (String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            if (anagramMap.containsKey(sortedKey)){
                anagramMap.get(sortedKey).add(word);
            } else {
                List<String> newList = new  ArrayList<>(Arrays.asList(word));
                anagramMap.put(sortedKey, newList);
            }

        }

        return new ArrayList<>(anagramMap.values());

    }
}
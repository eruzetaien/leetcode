class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Integer[] sortedCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedCitations, Collections.reverseOrder());

        int i = 0;
        while (sortedCitations[i] >= i + 1 && i < n){
            System.out.println(i);
            System.out.println(sortedCitations[i]);
            System.out.println();
            i++;

        }

        return i;
    }
}
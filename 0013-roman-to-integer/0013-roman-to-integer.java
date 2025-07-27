class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int curr = romToInt.get(s.charAt(i));
            int next = (i + 1 < n) ? romToInt.get(s.charAt(i + 1)) : 0;

            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }

        return total;
    }
}

class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= 1){return s;}

        StringBuilder sb = new StringBuilder();

        int gap = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++){
            int pointer = i;
            int neighGap = (numRows -1 - i) * 2;

            while (pointer < n ){
                sb.append(s.charAt(pointer));
                if (neighGap > 0 && neighGap != gap && (pointer + neighGap) < n ){
                    sb.append(s.charAt(pointer+neighGap));
                }
                pointer += gap;
            }

        }

        return sb.toString();
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        List<String> output = new ArrayList<String>();

        int startIdx = -1;
        int endIdx = -1;
        int width = 0;
        for (int i = 0; i < n; i++){
            int spaceBetween = (startIdx == -1 || endIdx == -1)? 1 : endIdx - startIdx + 1;
            boolean canFit = width + words[i].length() + spaceBetween <= maxWidth;
            if (canFit){
                if (startIdx == -1){
                    startIdx = i;
                } else {
                    endIdx = i;
                }
                width += words[i].length();

            } else {
                if (startIdx != -1){
                    if (endIdx == -1){endIdx = startIdx;}

                    int totalPad = maxWidth - width;
                    int numOfGap = endIdx - startIdx;
                    if (numOfGap == 0){
                        output.add(words[startIdx] + " ".repeat(totalPad));
                    } else {
                    int spacePerGap = totalPad / numOfGap;
                        int additionalSpace = totalPad % numOfGap;

                        StringBuilder sb = new StringBuilder();

                        for (int j = startIdx; j < endIdx; j++){
                            sb.append(words[j]);
                            int extraSpaces = ((j - startIdx) < additionalSpace) ? 
                                spacePerGap + 1 : spacePerGap;
                            sb.append(" ".repeat(extraSpaces));
                        }
                        sb.append(words[endIdx]);

                        output.add(sb.toString());
                    }

                    
                }
                startIdx = i;
                endIdx = -1;
                width = words[i].length();
            }
            
        } 

        if (endIdx == -1){
            int totalPad = maxWidth - width;
            output.add(words[startIdx] + " ".repeat(totalPad));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = startIdx; i < endIdx; i++){
                sb.append(words[i]);
                sb.append(" ");
            }
            sb.append(words[endIdx]);
            int totalPad = maxWidth - sb.length();
            if (totalPad > 0){sb.append(" ".repeat(totalPad));}
            
            output.add(sb.toString());

        }

        return output;

    }
}
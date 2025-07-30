class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int leftPointer = 0;
        int rightPointer = n-1;

        s = s.toLowerCase();

        while (leftPointer < rightPointer){
            boolean leftCharValid = isAlphanumeric(s.charAt(leftPointer));
            boolean rightCharValid = isAlphanumeric(s.charAt(rightPointer));
            
            if (leftCharValid && rightCharValid){
                if (s.charAt(leftPointer) != s.charAt(rightPointer)){
                    return false;
                }
                
                leftPointer++;
                rightPointer--;
                continue;
            }

            if (!leftCharValid){
                leftPointer++;
            }

            if (! rightCharValid){
                rightPointer--;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char c){
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}
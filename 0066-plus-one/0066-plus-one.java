class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length; 
        boolean isAllNine = true;
        for (int i = 0; i < n; i++){
            if (digits[i] != 9){
                isAllNine = false;
                break;
            }
        }

        if (isAllNine){
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }

        int reminder = 1;
        int pointer = n - 1;
        while (reminder > 0 && pointer >= 0){
            digits[pointer] += 1;
            reminder -= 1;
            if (digits[pointer] == 10){
                digits[pointer] = 0;
                reminder += 1;
            }
            pointer -= 1;
        }
        return digits;
    }
}
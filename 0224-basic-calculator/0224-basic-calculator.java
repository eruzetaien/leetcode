class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                // Build multi-digit number
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // Adjust because outer loop will increment
                result += sign * num;
            } 
            else if (ch == '+') {
                sign = 1;
            } 
            else if (ch == '-') {
                sign = -1;
            } 
            else if (ch == '(') {
                // Save current result and sign
                stack.push(result);
                stack.push(sign);
                // Reset for inner expression
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // Complete the parenthesis evaluation
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
        }
        
        return result;
    }
}
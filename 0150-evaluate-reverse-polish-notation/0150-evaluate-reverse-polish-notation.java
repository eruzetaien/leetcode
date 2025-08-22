class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            try {
                int num = Integer.parseInt(token);
                stack.add(num);
            } catch (NumberFormatException e) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(token){
                    case "+":
                        stack.add(num1+num2);
                        break;
                    case "-":
                        stack.add(num1-num2);
                        break;
                    case "*":
                        stack.add(num1*num2);
                        break;
                    case "/":
                        stack.add(num1/num2);
                        break;
                    default:
                        System.out.println("Invalid Token");
                }
                // System.out.println(stack);
            }

            
        }

        return stack.pop();
    }
}
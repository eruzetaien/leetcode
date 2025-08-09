class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if (parenthesesMap.containsKey(ch)){
                stack.push(ch);
            } else {
                if (stack.empty() || parenthesesMap.get(stack.pop()) != ch){
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
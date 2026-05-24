class Solution {
    public boolean isValid(String s) {
        // O(n) Time and O(n) Space
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty()) {
                    char popped = stack.pop();
                    if(isMatching(popped,ch)) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char popped, char current) {
        if( (popped == '(' && current == ')') ||
            (popped == '[' && current == ']') ||
            (popped == '{' && current == '}')) {
                return true;
            }
        return false;
    }
}

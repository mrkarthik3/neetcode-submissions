class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                stack.push(ch);
            } else {
                if(stack.size() == 0 || map.get(ch) != stack.pop()){
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}

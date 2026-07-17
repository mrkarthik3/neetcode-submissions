class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < operations.length; i++) {
            if(operations[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
            } else if(operations[i].equals("C")) {
                stack.pop();
            } else if(operations[i].equals("D")) {
                stack.push(stack.peek()*2);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;
        while(stack.size() > 0){
            sum += stack.pop();
        }
        return sum;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            List<Integer> current = List.of(temperatures[i], i); 
            while(stack.size() > 0 && stack.peek().get(0) < current.get(0)){
                List<Integer> top = stack.pop();;
                res[top.get(1)] = current.get(1) - top.get(1);
            }
            stack.push(current);
        }
        return res;
    }
}

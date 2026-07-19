class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] data = new int[n][2];
        for(int i = 0; i < n; i++){
            data[i][0] = position[i];
            data[i][1] = speed[i]; 
        }
        Arrays.sort(data, (a,b) -> b[0] - a[0]);

        ArrayDeque<Double> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int[] current = data[i];
            double time = (target-current[0])/(double)current[1];
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            } 
        }
        return stack.size();
    }
}

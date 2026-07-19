class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Brute force O(n^2) TC and O(n) SC
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }
}

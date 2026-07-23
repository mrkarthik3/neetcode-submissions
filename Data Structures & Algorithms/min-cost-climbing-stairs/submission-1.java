class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return (int)Math.min(
            minCost(cost, 0, new HashMap<>()), 
            minCost(cost, 1, new HashMap<>())
            );
    }
    public double minCost(int[] cost, int idx, HashMap<Integer,Double> memo){
        if(idx == cost.length) return 0;
        if(idx > cost.length) return Double.POSITIVE_INFINITY;
        if(memo.containsKey(idx)) return memo.get(idx);

        double oneStepCost = cost[idx] + minCost(cost, idx+1, memo);
        double twoStepCost = cost[idx] + minCost(cost, idx+2, memo);
        
        double result = Math.min(oneStepCost, twoStepCost);
        memo.put(idx, result);
        return result;
    }
}

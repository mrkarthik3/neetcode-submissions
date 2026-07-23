class Solution {
    public int climbStairs(int n) {
        return startClimb(0, n, new HashMap<>());
    }
    public int startClimb(int pos, int n, HashMap<Integer,Integer> memo){
        if(pos == n) return 1;
        if(pos > n) return 0;
        if(memo.containsKey(pos)) return memo.get(pos);

        int result = startClimb(pos + 1, n, memo) + startClimb(pos + 2, n, memo);
        memo.put(pos, result);
        return result;
    }
}

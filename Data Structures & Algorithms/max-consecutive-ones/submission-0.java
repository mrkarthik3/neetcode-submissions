class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0;
        int i = 0;
        int localMax = 0;
        while(i < nums.length){
            if(nums[i] == 1) {
                localMax++;
                globalMax = Math.max(localMax, globalMax);
            } else {
                localMax = 0;
            }
            i++;
        }
        return globalMax;
    }
}
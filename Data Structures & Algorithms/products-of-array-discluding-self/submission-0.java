class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* ALGORITHM - BRUTE FORCE O(n^2) Time and O(n) Space
        Only uses multiplying => no issues with div/0
        */
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j < nums.length; j++) {
                // inner loop calculates the actual product except self
                if(i != j) product = product*nums[j];
            }
            result[i] = product;
        }
        return result;
    }
}  

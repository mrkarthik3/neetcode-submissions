class Solution {
    public int[] getConcatenation(int[] nums) {
        // O(n) space and time
        int n = nums.length;
        int[] ans = new int[2*n];

        for(int i = 0; i < 2*n; i++) {
            ans[i] = nums[i%n];
        }
        return ans;
    }
}
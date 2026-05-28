class Solution {
    public void moveZeroes(int[] nums) {
        // O(n) Time and O(1) Space
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            if(nums[l] == 0 && nums[r] != 0) {
                // swap
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if(nums[l] != 0) {
                l++;
            }
            r++;
        }
    }
}
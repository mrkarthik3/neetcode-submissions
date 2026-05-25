class Solution {
    public int removeDuplicates(int[] nums) {
        // Neetcode's algo implemented. Very nice.
        // O(n) Time and O(1) Space
        int l = 1;
        int r = 1;
        while(r < nums.length) {
            if(nums[r] != nums[r-1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }    
        return l;  
    }
}
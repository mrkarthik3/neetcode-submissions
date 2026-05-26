class Solution {
    public int findMin(int[] nums) {
        // [4,-1,0,1,2,3]
        // [4,5,3,3,3,3]
        // [3,4,5,6,1,2]
        // Simply do dry run and write the code. Very simple
        // O(log n) Time and O(1) Space
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = l + (r-l)/2 ;
            if(nums[m] > nums[r]) {
                // min val will be to the right
                l = m + 1;
            } else {
                // min val will be to the left
                r = m;
            }
        }
        // l is the index of min value at the end
        return nums[l];
    }
}

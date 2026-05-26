class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        // Must use <= because the search should continue while there is still
        // one candidate element left to check.
        while(l <= r) {
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}

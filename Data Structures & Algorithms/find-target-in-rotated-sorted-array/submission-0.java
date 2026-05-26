class Solution {
    public int search(int[] nums, int target) {
        // O(log n) Time & O(1) Space
        // Algo
        // 1. find the pivot
        // 2. perform Bin.Search on left and right parts
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = l + (r-l)/2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int pivot = l;

        int result = binarySearch(nums, target, 0, pivot-1);
        if(result != -1) return result;

        return binarySearch(nums, target, pivot, nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int l, int r) {
        while(l<=r) {
            int m = l+(r-l)/2;
            if(nums[m] == target) {
                return m;
            } else if(nums[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}

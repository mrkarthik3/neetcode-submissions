class Solution {
    public int trap(int[] height) {
        // It is possible to do this in O(1) space via 2-pointer approach
        int l = 0;
        int r = height.length-1;
        // For this 2-pointer algo, we have to be inclusive for maxleft and maxright found so far.
        int maxLeftSoFar = height[0];
        int maxRightSoFar = height[height.length-1];
        int totalTrappedWater = 0;
        while(l < r) {
            // remember to be inclusive for 2-pointer algo
            maxLeftSoFar = Math.max(maxLeftSoFar, height[l]);
            maxRightSoFar = Math.max(maxRightSoFar, height[r]);
            int leftHeight = height[l];
            int rightHeight = height[r];
            if(maxLeftSoFar < maxRightSoFar) {
                int currentWater = maxLeftSoFar - leftHeight < 0 ? 0 : maxLeftSoFar - leftHeight;
                totalTrappedWater += currentWater;
                l++; 
            } else {
                int currentWater = maxRightSoFar - rightHeight < 0 ? 0 : maxRightSoFar - rightHeight;
                totalTrappedWater += currentWater;
                r--;
            }
        }

        return totalTrappedWater;
    }
}

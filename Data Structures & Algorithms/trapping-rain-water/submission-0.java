class Solution {
    public int trap(int[] height) {
        // O(n) Time and O(n) Space
        // You have to know the formula to solve this question
        // Just understand the algo and remember it.
        int[] maxRightTillNow = new int[height.length];
        int[] maxLeftTillNow = new int[height.length];
        maxRightTillNow[height.length-1] = 0;
        maxLeftTillNow[0] = 0;
        for(int i = 1; i < height.length;i++) {
            // You have to exclude i from max calcualation!! VERY IMPORTANT
            maxLeftTillNow[i] = Math.max(maxLeftTillNow[i-1], height[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--) {
            // You have to exclude i from max calcualation!! VERY IMPORTANT
            maxRightTillNow[i] = Math.max(maxRightTillNow[i+1], height[i+1]);
        }
        
        // Water trapped at ith index = 
        // Min(max. left ht seen so far excl i - max. right ht seen so far excl i)
        // -
        // height at index i

        // I'm creating separate arrays here because this solution will take O(n) space anyway
        // Also this is first time I am solving this Q on my own.
        // So clairty is paramount.
        int[] minOfMaxDifferences = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            minOfMaxDifferences[i] = Math.min(maxLeftTillNow[i], maxRightTillNow[i]);
        }

        int totalWaterTrapped = 0;
        int[] waterTrapped = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            int qty = minOfMaxDifferences[i] - height[i];
            waterTrapped[i] = qty < 0 ? 0 : qty;    
            totalWaterTrapped += waterTrapped[i];
        }

        return totalWaterTrapped;

    }
}

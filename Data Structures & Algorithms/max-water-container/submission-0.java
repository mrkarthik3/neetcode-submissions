class Solution {
    public int maxArea(int[] heights) {
        // BRUTE FORCE - O(n^2)
        int n = heights.length;
        int globalMax = 0;
        for(int i = 0; i < n; i++) {
            int area = 0;
            for(int j = i+1; j < n; j++) {
                int xLength = j - i;
                int yHeight = Math.min(heights[i], heights[j]);
                area = xLength*yHeight;
                globalMax = Math.max(globalMax,area);
            }
        }
        return globalMax;
        
    }
}

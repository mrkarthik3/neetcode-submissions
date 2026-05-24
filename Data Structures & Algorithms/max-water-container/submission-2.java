class Solution {
    public int maxArea(int[] heights) {
        // O(n) Time - Two pointer approach
        // O(1) Space
        int n = heights.length;
        int i = 0;
        int j = n-1;
        int globalMax = 0;
        while(i < j) {
            int xLength = j - i;
            int yHeight = Math.min(heights[i], heights[j]);
            int area = xLength * yHeight;
            globalMax = Math.max(area, globalMax);
            if(heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return globalMax;
    }
}

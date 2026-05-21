class Solution {
    public int[] replaceElements(int[] arr) {
        // In-place algo
        // O(1) Space and O(n) Time
        int rMax = -1;
        for(int i = arr.length-1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = rMax; // --> Key step! Do this before calc of max.
            rMax = Math.max(current, rMax);
        }
        return arr;
    }
}
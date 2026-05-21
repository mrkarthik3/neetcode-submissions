class Solution {
    public int[] replaceElements(int[] arr) {
        // O(n^2) Time & O(n) Space
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = rightMax(arr, i+1);
        }
        return result;
    }

    private int rightMax(int[] arr, int startIdx) {
        if(startIdx == arr.length) return -1;
        int max = arr[startIdx]; // some initial value
        for(int i = startIdx; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
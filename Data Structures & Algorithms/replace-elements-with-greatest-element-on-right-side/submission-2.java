class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length-1] = -1;
        int max = arr[arr.length-1]; // starting value
        for(int i = arr.length-2; i >= 0; i--){
            max = Math.max(arr[i+1], max);
            res[i] = max;
        }
        return res;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Approach 1
        // Count frequency of each number
        // create [num, freq] arrays for each frequency and sort it by freq
        // You have to use comparator for this sorting (do decreasing sort)
        // Iterate the sorted 2d array k times and fetch the nums
        // return those nums in array form

        // O(nlogn) = TC, due to sorting
        // O(n) = SC due to map and lists generated

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        List<int[]> pairs = new ArrayList<>();

        for(int key : map.keySet()){
            pairs.add(new int[]{key, map.get(key)});
        }

        // keys = nums = index 0
        // vals = frequencies = index 1
        // sort in decreasing order of frequencies
        pairs.sort((a,b) -> b[1]-a[1]);

        // iterate till k
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pairs.get(i)[0];
        }

        return result;
        
    }
}

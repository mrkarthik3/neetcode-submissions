class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Approach 4 - Bucket Sort.
        // O(n) Time and Space

        // 1. Create map of frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        // 2. Create an array of size = input array length + 1
        // Type of array should be List<Integer>
        // This will store elements of each frequency.
        // index in this list = frequency in map
        List<Integer>[] listArray = new List[nums.length+1];
        for(int i = 0; i < listArray.length; i++) {
            listArray[i] =  new ArrayList<>();
        }
        //System.out.println(Arrays.toString(listArray));

        // fill the list array by iterating over map
        // key = num, value = freq
        for(int key : map.keySet()) {
            listArray[map.get(key)].add(key);
        }

        //System.out.println(Arrays.toString(listArray));

        int[] result = new int[k];
        int idx = 0;
        for(int i = listArray.length-1; i>=0; i--) {
            if(listArray[i].size() > 0) {
                // if one frequency has a list with more than 1 element
                // add them into the result
                for(int j = 0; j < listArray[i].size(); j++) {
                    result[idx] = listArray[i].get(j);
                    idx = idx +1;
                    if(idx == k) return result; 
                    // always returns here           
                }
            }
        }

        return result;
    }
}

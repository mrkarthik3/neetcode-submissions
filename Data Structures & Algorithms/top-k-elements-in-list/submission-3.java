class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Approach 3 using max heap -> less efficient than min heap approach(2)
        // O(n) = Space due to map and heap
        // Time = n.log(k) due to heap operations

        // 1. find frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            } 
        }

        // 2. Create max heap and push [freq, num] into it.
        // Set freq for heap's sorting priority
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        // key = num & value = freq
        for(int key : map.keySet()) {
            maxheap.offer(new int[]{map.get(key), key});
        }

        // 3. Collect the first k items from this max heap
        // They're the highest freq items
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = maxheap.poll()[1];
        }

        return result;
    }
}

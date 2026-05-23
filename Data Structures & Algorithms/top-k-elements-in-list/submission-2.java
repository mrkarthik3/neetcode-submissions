class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Approach 2
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

        // 2. Create min heap and push [freq, num] into it.
        // Set freq for heap's sorting priority
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        // key = num & value = freq
        for(int key : map.keySet()) {
            minHeap.offer(new int[]{map.get(key), key});
            // Keep at most 'k' items in minHeap
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. Collect the last k items from heap
        // They're the highest freq items
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[1];
        }

        return result;
    }
}

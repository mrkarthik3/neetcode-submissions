class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        // O(n) Time & Space
        // starting longest = 0 handles empty nums array case.
        int longest = 0;
        for(int num : nums) {
        int seq = 0;
            if(!set.contains(num-1)) {
                // implies start of a sequence from num
                seq = 1;
                while(set.contains(num+1)){
                    seq+=1;
                    num=num+1;
                }
                longest = Math.max(longest, seq);
            }
        }
        return longest;
    }
}

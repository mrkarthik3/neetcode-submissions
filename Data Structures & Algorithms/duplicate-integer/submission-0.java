class Solution {
    public boolean hasDuplicate(int[] nums) {
        // O(n) space and time
        HashSet<Integer> uniques = new HashSet<>();
        for(int num : nums) {
            uniques.add(num);
        }

        return uniques.size() != nums.length;
        
    }
}
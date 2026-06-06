class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniques = new HashSet<>();
        // Since the array is unsorted, so, O(n) is the TC and SC
        for(int num : nums) uniques.add(num);
        // return true if dupes are present.
        return uniques.size() != nums.length;
    }
}
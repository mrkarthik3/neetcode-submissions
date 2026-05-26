class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();
        for(int num : nums1) nums1Set.add(num);
        for(int num : nums2) nums2Set.add(num);
        List<Integer> commonItems = new ArrayList<>();
        for(int n : nums1Set) {
            if(nums2Set.contains(n)){
                commonItems.add(n);
            }
        }
        int[] result = new int[commonItems.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = commonItems.get(i);
        }
        return result;
    }
}
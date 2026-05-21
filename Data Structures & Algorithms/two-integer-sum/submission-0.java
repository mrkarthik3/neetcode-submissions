class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> alreadySeen = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // check if current's complement is already seen (in map)
            int complement = target-current;
            if(alreadySeen.containsKey(complement)) {
                result[1] = i;
                result[0] = alreadySeen.get(complement);
                // return new int[]{i, alreadySeen.get(complement)};
            } else {
                alreadySeen.put(current, i);
            }
        }
        return result;
    }
}

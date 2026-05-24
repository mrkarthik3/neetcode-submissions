class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // O(n) Space and O(n^2) Time
        // Outer for loop and nested while loop => n*n
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) break;
            // nums[i-1] is already processed. 
            // So when i-1 and i elements are equal, you can skip current ith element.
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                if(nums[i] + nums[j]+ nums[k] == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // this ensures dupes for j are skipped
                    while(j < k && nums[j] == nums[j-1]) j++;
                    // no need to skip dupes for k.
                    // existing k-- will take care of it.
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
        
    }
}

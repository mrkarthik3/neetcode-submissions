class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] == val) k++;
        }

        int i = 0;
        int j = nums.length-1;
        while(i < j){
            if(nums[j] == val){
                j--;
            } else if(nums[i] != val){
                i++;
            } else {
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums.length-k;
    }
}
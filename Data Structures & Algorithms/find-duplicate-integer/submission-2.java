class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        boolean isFirstIteration = true;
        while(true){
            if(!isFirstIteration && fast == slow) {
                break;
            }
            fast = nums[nums[fast]];
            slow = nums[slow];
            isFirstIteration = false;
        }
        // currently, slow is at a point where both fast and slow met
        // that is confirmation of cycle's presence.
        
        // But since this Q requires duplicate number in the array (LL)
        // Answer is the starting point of the cycle.
        // Currently, 'slow' may not be equal at the duplicate number.

        // To reach start of cycle representing duplicate number,
        // start another slow2 pointer and move both slow and slow2 by 1
        // Their meeting place = duplicate number.
        int slow2 = 0;
        while(slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}

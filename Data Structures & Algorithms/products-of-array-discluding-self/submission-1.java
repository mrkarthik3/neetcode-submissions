class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* ALGORITHM - BRUTE FORCE O(n) Time and O(n) Space
        Uses prefix product and suffix product arrays.
        Since the answer requires product of all elements "excluding self",
        exclude the "self" element while creating prefix and suffix arrays.
        This is the special part unlike traditional prefix/suffix prod/sum where you would include the "SELF"
        */
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        // [1,2,4,6]

        prefix[0] = 1;
        int product = 1;
        for(int i = 1; i < nums.length; i++){
            product = product * nums[i-1];
            prefix[i] = product;
        }
        
        suffix[nums.length-1] = 1;
        product = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            product = product * nums[i+1];
            suffix[i] =  product;
        }

        //System.out.println(Arrays.toString(prefix));
        //System.out.println(Arrays.toString(suffix));

        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  

class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* ALGORITHM - Best Optimized O(n) Time and O(1) Space
            Here, from 0 - n-1, fill the result array with the prefix products (excluding self)
            In next pass, from n-1 to 0, calculate suffix products on the fly and..
            multiply the suffix product at each index with the prefix products in the array.
            This simulates product of all elements excluding self. 
        */
        int[] result = new int[nums.length];

        result[0] = 1;
        int product = 1;
        for(int i = 1; i < nums.length; i++){
            product = product * nums[i-1];
            result[i] = product;
        }
        //System.out.println(Arrays.toString(result));

        int suffixProd = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            result[i] = suffixProd * result[i]; // suffix * prefix
            suffixProd = suffixProd * nums[i]; // suffix = suffix * nums[i]
            // note that for suffix you should multiply with 'nums', but not 'result'
        }
        //System.out.println(Arrays.toString(result));
        
        return result;
    }
}  

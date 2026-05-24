class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // O(1) Space and O(n) Time
        int i = 0;
        int j = numbers.length-1;
        int[] result = new int[2];
        while(i < j){
            if(numbers[i] + numbers[j] == target) {
                result[0] = i+1;
                result[1] = j+1;
                // return new int[]{i+1, j+1};
                // guaranteed to return here
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;        
    }
}

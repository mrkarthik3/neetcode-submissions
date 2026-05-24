class Solution {
    public int lengthOfLastWord(String s) {
        // O(n) Time and O(1) space.
        int i;
        s = s.trim();
        for(i = s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                break;
            }
        }
        return s.length()-1-i;
    }
}
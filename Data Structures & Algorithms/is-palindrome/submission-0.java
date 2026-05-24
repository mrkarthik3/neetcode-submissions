class Solution {
    public boolean isPalindrome(String s) {
        // O(n) Time and O(1) Space
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(!isAlphaNum(s.charAt(i))) {i++; continue;}
            if(!isAlphaNum(s.charAt(j))) {j--; continue;}
            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));
            if(l != r) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        if( c >= 'a' && c <= 'z' 
         || c >= 'A' && c <= 'Z'
         || c >= '0' && c <= '9') return true;
         return false;
    }
}

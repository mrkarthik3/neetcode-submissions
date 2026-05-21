class Solution {
    public boolean isSubsequence(String s, String t) {
        // O(1) Space and O(n+m) Time
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        if(i == s.length()) {
            // all letters in s were found in t
            return true;
        }
        return false;
    }
}
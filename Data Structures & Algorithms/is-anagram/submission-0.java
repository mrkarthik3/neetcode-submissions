class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for(int i = 0; i < s.length(); i++) {
            if(sChars[i] != tChars[i]) return false;
        }

        // It is anagram if all elements in both arrays are identical.
        return true; 

    }
}

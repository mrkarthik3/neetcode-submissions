class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Hashset approach
        // O(n) Time and Space

        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        // Concise version inside
        while(j < s.length()){
            char ch = s.charAt(j);
            if(set.contains(ch)) {
                // => ch is already present
                // move i such that the substring has no previous ch
                while(set.contains(ch)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            // if set doesn't contain ch, just add it and increment j by default.
            set.add(ch);
            j++;
            maxLen = Math.max(maxLen, j-i);
        }
        return maxLen;
    }
}

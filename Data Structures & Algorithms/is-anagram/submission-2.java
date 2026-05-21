class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> sCount = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch)+1);
            } else {
                sCount.put(ch, 1);
            }
        }

        for(char ch : t.toCharArray()) {
            if(sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch)-1); // subtracting
            } else {
                return false; // proved that it is not anagram
            }
        }

        // for(int freq : sCount.values()){
        //     // atleast 1 value != 0 => not anagram
        //     if (freq != 0) return false;
        // }
         for(char key : sCount.keySet()){
            // atleast 1 value != 0 => not anagram
            if (sCount.get(key) != 0) return false;
        }

        // all values are 0 => it is anagram
        return true; 
    }
}

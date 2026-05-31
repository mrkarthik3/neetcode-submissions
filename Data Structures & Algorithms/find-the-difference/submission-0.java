class Solution {
    public char findTheDifference(String s, String t) {
      int[] sFreq = new int[26]; 
      int[] tFreq = new int[26];
      for(int i = 0; i < s.length(); i++) {
        sFreq[s.charAt(i) - 'a']++;
      }
      for(int i = 0; i < t.length(); i++) {
        tFreq[t.charAt(i) - 'a']++;
      }
      for(int i = 0; i < 26; i++) {
        if(sFreq[i] != tFreq[i]) {
            char ans = (char) ('a' + i);
            return ans;
        }
      }
      return ' ';
    }
    
}
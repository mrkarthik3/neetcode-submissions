class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sCount = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++) {
            char current = s.charAt(i);
            sCount.put(current, sCount.getOrDefault(current, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char current = t.charAt(i);
            if(!sCount.containsKey(current)) return false;
            sCount.put(current, sCount.get(current)-1);
        }

        for(int count : sCount.values()){
           if(count != 0) return false;
        }
        return true;
    }
}

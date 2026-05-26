class Solution {
    public String minWindow(String s, String t) {
        // O(n) Time and O(n) Space. Both linear.
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        
        String shortestStr = "";
        int minLen = Integer.MAX_VALUE;
        int tCounter = 0;
        for(int count : tMap.values()) {
            tCounter += count;
        }
        int sCounter = 0;
        System.out.println(tCounter);
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            // only interested in counting chars already present in t
            if(tMap.containsKey(s.charAt(r))) {
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r),0)+1);
                sCounter++;
            }
            
            // System.out.println("sCounter : " + sCounter);
            // System.out.println("sMap : " + sMap);
            // System.out.println("tMap : " + tMap);
            while(sCounter >= tCounter && isOverlapped(sMap,tMap)) {
                if(r-l+1 < minLen) {
                    shortestStr = s.substring(l,r+1);
                    minLen = Math.min(minLen, r-l+1);
                }
                if(sMap.containsKey(s.charAt(l))) {
                    sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                    sCounter--;
                }
                l++;
            }

        }
        return shortestStr;
    }
    public static boolean isOverlapped(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for(char key : tMap.keySet()) {
            if (tMap.get(key) > sMap.getOrDefault(key, 0)) return false;
        }
        return true;
    }
}

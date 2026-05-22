class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet<Integer> processedIndices = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i < strs.length; i++) {
            if(!processedIndices.contains(i)) {
                processedIndices.add(i);
                List<String> subResult = new ArrayList<>();
                subResult.add(strs[i]);
                int j = i+1;
                while(j < strs.length) {
                    boolean canAdd = isAnagram(strs[i],strs[j]);
                    if(canAdd) {
                        subResult.add(strs[j]);
                        processedIndices.add(j);
                    } 
                    j++;
                }
                result.add(subResult);
            }
        }

        return result;
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sCount = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch)+1);
            } else {
                sCount.put(ch, 1);
            }
        }

        for(char ch : t.toCharArray()) {
            if(sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch)-1);
            } else {
                return false;
            }
        }

        for(int freq : sCount.values()) {
            if(freq != 0) return false;
        }

        return true;
    }
}

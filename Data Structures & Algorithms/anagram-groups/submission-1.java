class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sort of brute force - O(k*n^2) Time complexity
        // Space: O(n) auxiliary.
        // Auxiliary space is simply: Extra space your algorithm allocates, excluding the input and output. 
        // Space : O(n × k) including output storage
        // Because you need to hold *n strings × k avg sized characters each* in memory at once.
        // n^2 because of nested loops.
        // k * n^2 because of anagram check inside innermost loop!!
        // n = length of input array
        // k = average length of strings
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

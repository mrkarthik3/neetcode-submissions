class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Time Complexity: O(m·n)
        // m = number of strings, n = average length of each string
        // For each of m strings, we iterate through n characters to build freq array
        // Arrays.toString() on fixed 26-element array = O(1), doesn't affect TC

        // Space Complexity: O(m) auxiliary (excl. input and output)
        // HashMap has at most m keys, each key is fixed size O(26) = O(1)
        // Total space including output = O(m·n) — output stores m strings of avg
        // length n, scales with both hence m·n and not m+n
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String freqArrString = getFreqArrayString(strs[i]);
            if(map.containsKey(freqArrString)) {
                map.get(freqArrString).add(strs[i]);
            } else {
                List<String> subList = new ArrayList<>();
                subList.add(strs[i]);
                map.put(freqArrString,subList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> subList : map.values()) {
            result.add(subList);
        }
        return result;
    }

    public static String getFreqArrayString(String s) {
        int[] freqArray = new int[26];
        for(char ch : s.toCharArray()) {
            int idx = ch - 'a';
            freqArray[idx]++;
        }
        return Arrays.toString(freqArray);
    }
}

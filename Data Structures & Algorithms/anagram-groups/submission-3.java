class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Time complexity = O(m*n)
        // m = no. of elements in strs array
        // n = fn call to create freqArrString iterates of avg 'n' characters of a string

        // Space complexity = O(m)
        // Because at most we store m strings.
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String freqArrString = getFreqArrString(strs[i]);
            if(map.containsKey(freqArrString)) {
                map.get(freqArrString).add(strs[i]);
            } else {
                map.put(freqArrString, new ArrayList<>(List.of(strs[i])));
            }
        }
        List<List<String>> groupedAnagrams = new ArrayList<>();
        for(List<String> group : map.values()){
            groupedAnagrams.add(group);
        }
        return groupedAnagrams;
    }

    public static String getFreqArrString(String str){
        int[] freqArray = new int[26];
        for(int i = 0; i < str.length(); i++){
            int pos = str.charAt(i) - 'a';
            freqArray[pos]++;
        }
        String freqArrString = Arrays.toString(freqArray);
        return freqArrString;
    }
}

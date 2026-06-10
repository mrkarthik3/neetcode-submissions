class Solution {

    // Time: O(m) where m = total characters across all strings
    // Space: O(m) for the output (StringBuilder/ArrayList)
    // O(1) auxiliary space (not counting output)
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // 5#Hello5#World
        // 0#
        List<String> decodedStrings = new ArrayList<>();
        
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            // now j is at # character
            int numPortion = Integer.parseInt(str.substring(i, j));
            String strPortion = str.substring(j+1, j+1+numPortion);
            // when numportion = 0, strPortion = ""
            // So, this takes care of empty string case.
            decodedStrings.add(strPortion);
            i = j + 1 + numPortion;
        }
        return decodedStrings;
    }
}

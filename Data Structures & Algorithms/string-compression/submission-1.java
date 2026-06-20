class Solution {
    public int compress(char[] chars) {
        char currentChar = chars[0];
        int currentCharCount = 0;
        String output = "";
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == currentChar){
                currentCharCount++;
            } else {
                output += Character.toString(currentChar) + (currentCharCount == 1 ? "" : currentCharCount);
                currentChar = chars[i];
                currentCharCount = 1;
            }
        }
        output += Character.toString(currentChar) + (currentCharCount == 1 ? "" : currentCharCount);

        for(int i = 0; i < output.length(); i++) {
            chars[i] = output.charAt(i);
        }
        System.out.println(output);
        return output.length();
    }
}
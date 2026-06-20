class Solution {
    public int compress(char[] chars) {
        char currentChar = chars[0];
        int currentCharCount = 0;
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == currentChar){
                currentCharCount++;
            } else {
                output =  output.append(Character.toString(currentChar)).append((currentCharCount == 1 ? "" : currentCharCount));
                currentChar = chars[i];
                currentCharCount = 1;
            }
        }
        output =  output.append(Character.toString(currentChar)).append((currentCharCount == 1 ? "" : currentCharCount));

        for(int i = 0; i < output.length(); i++) {
            chars[i] = output.toString().charAt(i);
        }
        System.out.println(output);
        return output.toString().length();
    }
}
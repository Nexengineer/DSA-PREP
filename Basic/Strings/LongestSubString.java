package Strings;

// [Medium]: Longest Substring Without Repeating Characters
// "abcabcbb" -> 3 (abc), "bbbbb" -> 1 (b)
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        
        int maxLength = 0;
        String subString = "";
        
        for(char c: s.toCharArray()){
            String current = String.valueOf(c);
            if(subString.contains(current)){
                subString = subString.substring(subString.indexOf(current)+1);
            }
            
            subString = subString + current;
            maxLength = Math.max(subString.length(), maxLength);
        }
        
        return maxLength;
    }
}

package Strings;

// [Medium]: Given a string s, return the longest palindromic substring in s.
// Example: "babad" => "bab", "cbbd" => "bb"
public class LongestPalindromeSubString {
    public String checkPalindrome(String s, int left, int right, String res){
        while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(res.length()<(right-left+1)){
                    res = s.substring(left, right+1);
                }
                left --;
                right ++;
            }
        return res;
    }
    
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return s;
        }
        String res = "";
        
        for(int i=0; i<s.length(); i++){
            res = checkPalindrome(s, i, i, res);
        }
        
        for(int i=0; i<s.length(); i++){
            res = checkPalindrome(s, i, i+1, res);
        }
        
        return res;
    }
}

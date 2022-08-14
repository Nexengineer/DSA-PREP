package Strings;

// [Easy] - Given a string s, return true if the s can be palindrome after deleting at most one character from it.
// Example - "aba" -> true, "abca" -> true, "abc" -> false
public class ValidPalindromeII {
    public boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if (s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        
        while (i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                if(isPalindrome(s,i+1,j)){
                    return true;
                }
                if(isPalindrome(s, i, j-1)){
                    return true;
                }
                return false;
            }
        }
        
        return true;
    }
}

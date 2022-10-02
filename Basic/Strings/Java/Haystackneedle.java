package Strings;

public class Haystackneedle {
    public static int strStr(String haystack, String needle) {
        if(needle.length()<0){
            return 0;
        }
        
        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j==needle.length() -1){
                    return i - j;
                } else {
                    j++;
                }
            } else {
                i= i-j;
                j = 0;
            }
            i++;
        }
        return -1;
    }
}

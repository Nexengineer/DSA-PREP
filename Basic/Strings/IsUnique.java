package Strings;

public class IsUnique {
    public static boolean checkBruteForce(String value){
        for (int i = 0; i<value.length(); i++){
            for (int j= i+1; j<value.length(); j++){
                if(value.charAt(j) == value.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static boolean check(String value){
        if(value.length() > 128) {
            return false;
        }
        // 1,111,998 - unicode unique values, 128 unique values and 256 for both caps and lowers in ascii
        boolean charSet[] = new boolean[128];
        for(int i=0; i<value.length(); i++) {
            int asciiValue = value.charAt(i);
            if(charSet[asciiValue]){
                return false;
            }
            charSet[asciiValue] = true;
        }
        return true;
    }
}

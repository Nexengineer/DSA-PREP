package Strings;
import java.util.*;

public class RomanInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> trans = new HashMap<>();
        trans.put('I', 1);
        trans.put('V', 5);
        trans.put('X', 10);
        trans.put('L', 50);
        trans.put('C', 100);
        trans.put('D', 500);
        trans.put('M', 1000);
        s = s.replace("IV","IIII");
        s = s.replace("IX","VIIII");
        s = s.replace("XL","XXXX");
        s = s.replace("XC","LXXXX");
        s = s.replace("CD","CCCC");
        s = s.replace("CM","DCCCC");
        int value = 0;
        for(int i=s.length()-1; i>=0; i--){
            value += trans.get(s.charAt(i));
        }
        return value;
    }
}

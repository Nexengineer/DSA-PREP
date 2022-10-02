package Strings;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;

// [EASY]
public class Permutation {
    public static boolean checkForPermutation(String first, String second){
        Map<String, Integer> occurance = new HashMap<>();
        for (int i=0; i< first.length(); i++){
            occurance.merge(first.substring(i, i+1), 1, Integer::sum);
        }

        for (int i=0; i< second.length(); i++){
            if(occurance.get(second.substring(i, i+1)) == null){
                return false;
            } else if(occurance.get(second.substring(i, i+1))<=0){
                return false;
            } else {
                Integer value = occurance.get(second.substring(i, i+1));
                occurance.put(second.substring(i, i+1), value-1);
            }
        }
        return true;
    }
}

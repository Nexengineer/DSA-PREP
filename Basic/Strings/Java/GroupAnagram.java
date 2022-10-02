package Strings;
import java.util.*;
// [Medium]: Given an array of strings strs, group the anagrams together. You can return the answer in any order
// Example: ["eat","tea","tan","ate","nat","bat"] => [["bat"],["nat","tan"],["ate","eat","tea"]]
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 0) {
            return null;
        }
        
        List<List<String>> returnList = new ArrayList<>();
        
        Map<Integer, List<String>> results = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            int sum = 0;
            String value = strs[i];
            for(int j=0; j<value.length(); j++){
                sum +=value.charAt(j);
            }
            results.putIfAbsent(sum, new ArrayList<String>());
            if(results.get(sum) != null){
                results.get(sum).add(value);
            }
        }
        
        for(int sum: results.keySet()){
            returnList.add(results.get(sum));
        }
        
        return returnList;
    }
}

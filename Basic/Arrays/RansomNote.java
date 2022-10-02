package Arrays;
import java.util.*;;
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cache = new HashMap<>();
        
        for(Character ch : magazine.toCharArray()){
            if(cache.get(ch) != null){
                cache.put(ch, cache.get(ch)+1);
            } else {
                cache.put(ch, 1);
            }
        }
        
        for(Character ch: ransomNote.toCharArray()){
            if(cache.get(ch) != null && cache.get(ch) > 0){
                cache.put(ch, cache.get(ch)-1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}

package Stack;
import java.util.Stack;
public class BackSpace {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(Character ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
                continue;
            }
            s1.push(ch);
        }
        
        for(Character ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
                continue;
            }
            s2.push(ch);
        }
        
        if(s1.size() != s2.size()){
            return false;
        }
        
        while(!s1.isEmpty()) {
            if(s1.peek() != s2.peek()){
                return false;
            }
            
            s1.pop();
            s2.pop();
        }
        
        return true;
    }  
}

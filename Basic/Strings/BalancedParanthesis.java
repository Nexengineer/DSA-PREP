package Strings;

// [Medium]:  Minimum Remove to Make Valid Parentheses 
// Example: "lee(t(c)o)de)" => "lee(t(c)o)de", "a)b(c)d" => "ab(c)d"
public class BalancedParanthesis {
    public String minRemoveToMakeValid(String s) {
        if(s.length()<0){
            return s;
        }
        
        int open = 0;
        StringBuilder builder = new StringBuilder();
        
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }
            if(c == ')'){
                if(open == 0){
                   continue; 
                }
                open--;
            }
            builder.append(c);
        }
        
        String sb = builder.toString();
        if(open == 0){
            return sb;
        }
        StringBuilder response = new StringBuilder();
        for(int i = sb.length()-1; i>=0; i--){
            if(sb.charAt(i) == '(' && open>0){
                open--;
                continue;
            }
            response.append(sb.charAt(i));
        }
        
        return response.reverse().toString();
    }
}

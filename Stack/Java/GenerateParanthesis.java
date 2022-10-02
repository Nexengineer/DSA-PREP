package Stack;
import java.util.*;

//[Medium]: Generate Parentheses => https://leetcode.com/problems/generate-parentheses/
public class GenerateParanthesis {
    Stack<String> stack = new Stack<>();
    List<String> response = new ArrayList<>();
    
    public void generateParenthesisRec(int n, int openN, int closedN){
        if(openN == closedN && openN == n){
            String temp = "";
            while (!stack.isEmpty()) {
                temp = stack.pop() + temp;
            }
            response.add(temp);
        }
        
        if(openN < n){
            stack.push("(");
            generateParenthesisRec(n, openN +1, closedN);
            stack.pop();
        }
        if(closedN < openN){
            stack.push(")");
            generateParenthesisRec(n, openN, closedN + 1);
            stack.pop();
        }
        
    }

    public List<String> generateParenthesis(int n) {
        generateParenthesisRec(n, 0, 0);
        return response;
    }
}

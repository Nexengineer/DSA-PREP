package Stack;
import java.util.*;

//[Medium] : Evaluate Reverse Polish Notation // https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class PolishCalculation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int op1;
        int op2;
        for(int i= 0; i< tokens.length; i++){
            switch(tokens[i]){
                case "+": op1 = Integer.parseInt(stack.pop());
                          op2 = Integer.parseInt(stack.pop());
                          stack.push(String.valueOf(op2+op1));
                          break;
                case "-": op1 = Integer.parseInt(stack.pop());
                          op2 = Integer.parseInt(stack.pop());
                          stack.push(String.valueOf(op2-op1));
                          break;
                case "/": op1 = Integer.parseInt(stack.pop());
                          op2 = Integer.parseInt(stack.pop());
                          stack.push(String.valueOf(op2/op1));
                          break;
                case "*": op1 = Integer.parseInt(stack.pop());
                          op2 = Integer.parseInt(stack.pop());
                          stack.push(String.valueOf(op2*op1));
                          break;
                default: 
                    stack.push(tokens[i]);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}

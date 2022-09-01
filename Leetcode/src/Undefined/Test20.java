package Undefined;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/3/15-11:13
 */
public class Test20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < chars.length){
            if(chars[i]=='(')   stack.push(')');
            else if(chars[i]=='[')  stack.push(']');
            else if(chars[i]=='{')  stack.push('}');
            else if(stack.isEmpty() || stack.pop()!=chars[i])   return false;
            i++;
        }
        return stack.size() == 0;
    }

    public boolean isValidV2(String s) {
        char[] array = s.toCharArray();
        int n = array.length;

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(i < n){
            char ch = array[i++];
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if(!stack.isEmpty()){
                if((ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{'))  stack.pop();
                else    return false;
            }else   return false;
        }
        return !stack.isEmpty();
    }

    @Test
    public void test(){
        String s = "()";
        boolean valid = isValidV2(s);
        System.out.println(valid);
    }

}

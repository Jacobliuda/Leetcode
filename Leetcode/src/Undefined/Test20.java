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

    @Test
    public void test(){
        String s = ")";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}

package jianzhi;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/5/6-14:43
 * @description
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int element : pushed) {
            stack.push(element);
            while(!stack.isEmpty() && idx < popped.length && stack.peek() == popped[idx]){
                stack.pop();
                idx++;
            }
        }
        return idx == popped.length;
    }

    @Test
    public void test() {
        int[] pushed = new int[]{1,2,3,4,5}, popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}

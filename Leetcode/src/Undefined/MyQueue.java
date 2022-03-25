package Undefined;

import java.util.Stack;

/**
 * @author Jacob
 * @creator 2022/3/22-11:32
 */
public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        this.s1.push(x);
    }

    public int pop() {
        if(this.s2.isEmpty())
           this.transfer();
        return this.s2.pop();
    }

    public int peek() {
        if(this.s2.isEmpty())
            this.transfer();
        return this.s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void transfer(){
        while(!this.s1.isEmpty())
            s2.push(s1.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

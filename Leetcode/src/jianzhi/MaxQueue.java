package jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jacob
 * @creator 2022/6/8-16:21
 * @description 实现查找最大元素 O(1) 的队列
 */
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    public void push_back(int value) {
        queue.offer(value);
        while(!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
    }
    public int pop_front() {
        if(queue.isEmpty()) return -1;
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }
}


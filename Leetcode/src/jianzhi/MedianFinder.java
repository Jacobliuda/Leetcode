package jianzhi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jacob
 * @creator 2022/4/26-17:05
 * @description
 */
public class MedianFinder {

    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(minHeap.size() == 0 || minHeap.peek() >= num){
            minHeap.offer(num);
            if(minHeap.size() > maxHeap.size() + 1)
                maxHeap.offer(minHeap.poll());
        }
        else{
            maxHeap.offer(num);
            if(maxHeap.size() > minHeap.size())
                minHeap.offer(maxHeap.poll());

        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else
            return (minHeap.peek() + maxHeap.peek()) / 2.0;

    }
}


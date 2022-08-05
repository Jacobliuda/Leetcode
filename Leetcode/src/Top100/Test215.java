package Top100;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jacob
 * @creator 2022/6/23-16:47
 * @description
 */
public class Test215 {


    

    // 用自带的优先队列实现
    public int findKthLargest_1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }

            @Override
            public boolean equals(Object obj) {
                return this.equals(obj);
            }
        });
        for (int num : nums) {
            heap.offer(num);
        }


        while(k-- > 1)
            heap.poll();
        return heap.poll();
    }

    @Test
    public void test(){
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int kthLargest = findKthLargest_1(nums, k);
        System.out.println(kthLargest);
    }
}

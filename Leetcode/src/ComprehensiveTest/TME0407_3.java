package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author Jacob
 * @creator 2022/4/7-19:56
 * @description 从数组中的数减去 k 次 x使得数组的最大值最小： 大根堆
 */
public class TME0407_3 {
    public int minMax(ArrayList<Integer> a, int k, int x){
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        Iterator<Integer> iterator = a.iterator();
        while(iterator.hasNext()){
            heap.add(iterator.next());
        }

        int cnt = k;
        while(k-- > 0){
            int i = heap.poll() - x;
            heap.add(i);
        }
        return heap.poll();
    }

    @Test
    public void test(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(7);
        integers.add(2);
        integers.add(1);
        int k = 3, x = 2;
        int i = minMax(integers, k, x);
        System.out.println(i);
    }
}

package ComprehensiveTest;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/4-15:06
 * @description
 */
public class NetEase0904_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        while(n-- > 0)  heap.offer(sc.nextInt());
        while(k-- > 0){
            int poll = heap.poll();
            poll -= x;
            heap.offer(poll);
        }

        System.out.println(heap.poll());
    }
}

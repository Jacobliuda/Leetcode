package Weekly;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**6044.花期内花的数目
 * @author Jacob
 * @creator 2022/4/24-16:01
 * @description
 */
public class Test6044 {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        // 首先定义 map 记录每朵花的花期
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] flower : flowers) {
           int start = flower[0], end = flower[1];
           map.put(start, map.getOrDefault(start, 0) + 1);
           map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        // 为每一个 person 定义索引 方便还原输出的顺序
        int n = persons.length;
        int[][] persons_order = new int[n][2];
        for (int i = 0; i < n; i++) persons_order[i] = new int[]{i, persons[i]};
        Arrays.sort(persons_order, (a, b)->a[1]-b[1]);

        // 按顺序遍历前面 map 的键值序列，从低到高进行计算，计算途中完成求解
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int[] ans = new int[persons.length];

        int i = 0, sum = 0;
        for (int[] person: persons_order) {
            while (i < keys.size() && keys.get(i) <= person[1])
                sum += map.get(keys.get(i++)); // 累加变化量
            ans[person[0]] = sum;
        }

        return ans;
    }

    @Test
    public void test(){
        int[][] flowers = new int[][]{{21,34},{17,37},{23,43},{17,46},{37,41},{44,45},{32,45}};
        int[] persons = new int[]{31,41,10,12};
        int[] ints = fullBloomFlowers(flowers, persons);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

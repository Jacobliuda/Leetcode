package ComprehensiveTest;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/2-21:20
 * @description
 */
public class OPPO0902_1 {
    public void fun(int[][] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums) {
            int i = 0;
            while(i + 1 < num.length){
                int start = map.getOrDefault(num[i], 0);
                int end = map.getOrDefault(num[i+1], 0);
                map.put(num[i], start + 1);
                map.put(num[i+1], end - 1);
                i+=2;
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

//        return


    }

    @Test
    public void test(){
        int[][] nums = new int[][]{{1234,1240}, {1236,1238,1245,1250}};
        fun(nums);
    }
}

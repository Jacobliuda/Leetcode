package ComprehensiveTest;

import java.util.*;
import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/8/27-20:25
 * @description
 */
public class jd0827_2 {

    public int minimumOperations(int[] nums) {

        int n = nums.length;

        if(n == 1)
            return 0;

        HashMap<Integer, Integer> oddMap = new HashMap<>();
        HashMap<Integer, Integer> evenMap = new HashMap<>();

        // 先存储输入数组
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0)
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            else
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);

        }

        ArrayList<Map.Entry<Integer, Integer>> oddList = new ArrayList<>(oddMap.entrySet());
        ArrayList<Map.Entry<Integer, Integer>> evenList = new ArrayList<>(evenMap.entrySet());

        Collections.sort(oddList, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        Collections.sort(evenList, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        //记录奇数位和偶数位出现频次最多的数字及频次
        int odd_r1key = oddList.get(0).getKey();
        int odd_r1value = oddList.get(0).getValue();
        int even_r1key = evenList.get(0).getKey();
        int even_r1value = evenList.get(0).getValue();

        if (odd_r1key != even_r1key)
            return n - odd_r1value - even_r1value;
        else {
            int even_r2value = 0, odd_r2value = 0;
            if(evenList.size() > 1)
                even_r2value = evenList.get(1).getValue();
            if(oddList.size() > 1)
                odd_r2value = oddList.get(1).getValue();
            return
                    Math.min(
                            n - odd_r1value - even_r2value,
                            n - odd_r2value - even_r1value
                    )
            ;
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{2, 1};
        int ans = minimumOperations(nums);
        System.out.println(ans);
    }
}

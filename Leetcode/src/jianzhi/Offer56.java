package jianzhi;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jacob
 * @creator 2022/4/28-20:33
 * @description
 */
public class Offer56 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }

    @Test
    public void test(){
        int[] nums = new int[]{3,4,3,3,};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}


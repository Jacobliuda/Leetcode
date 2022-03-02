package Undefined;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/2-19:16
 */
public class Test1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int summa = 0;
        int ans = Integer.MIN_VALUE;

        for (int end = 0; end < length; end++) {
            summa += nums[end];
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if (end - start + 1 == map.size())
                ans = Math.max(ans, summa);
            while (end - start + 1 > map.size()) {
                Integer orDefault = map.getOrDefault(nums[start], 0);
                map.put(nums[start], orDefault-1);
                if(orDefault==1)
                    map.remove(nums[start]);
                summa-=nums[start++];
            }
        }
        return ans;
    }


    @Test
    public void test(){
        int[] nums = new int[]{4,2,3,4,5};
        int i = maximumUniqueSubarray(nums);
        System.out.println(i);
    }
}

package Undefined;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/11-15:08
 */
public class Test1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        Integer pos = null;
        for(i = 0; i < nums.length; i++){
            int val = target - nums[i];
            pos = map.get(val);
            if(pos != null)
                break;
            else
                map.put(nums[i], i);
        }
        return new int[]{i, pos};
    }

    @Test
    public void test(){
        int[] ints = new int[]{3,2,4};
        int target = 6;
        int[] ints1 = twoSum(ints, target);
        for(int i: ints1)
            System.out.println(i);
    }
}

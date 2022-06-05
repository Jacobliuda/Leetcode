package Undefined;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/3/19-19:19
 */
public class Test300 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        if(nums.length == 0)    return 0;
        dp.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(num > dp.get(dp.size()-1))
                dp.add(num);
            else{
                int idx = Collections.binarySearch(dp, num);
                if(idx < 0)
                    idx = -idx -1;
                dp.set(idx, num);
            }
        }
        return dp.size();
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,1,0,3,2,3};
//        int i = lengthOfLIS(nums);
//        System.out.println(i);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers.add(8);
        integers.add(10);
        integers.add(12);
        System.out.println(Collections.binarySearch(integers, 14));


    }
}

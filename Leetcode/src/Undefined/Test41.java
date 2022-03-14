package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/14-21:11
 */
public class Test41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(nums[i] <= 0)
                nums[i] = length + 1;
        }

        for(int i = 0; i < length; i++){
            int num = Math.abs(nums[i]);
            if(num <= length)
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }

        int i;
        for(i = 0; i < length; i++){
            if(nums[i] > 0)
                return i + 1;
        }
        return i + 1;
    }

    @Test
    public void test(){
        int[] nums = new int[]{3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
}

package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/2-18:52
 */
public class Test209 {
    public int minSubArrayLen(int target, int[] nums) {
        int summa = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for(int end = 0; end < nums.length; end ++){
            summa += nums[end];
            if(summa >= target)
                minLength = Math.min(minLength, end-start+1);
            while(summa >= target){
                minLength = Math.min(minLength, end-start+1);
                summa-=nums[start++];
            }
        }
        return minLength!=Integer.MAX_VALUE ? minLength : 0;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);
    }
}

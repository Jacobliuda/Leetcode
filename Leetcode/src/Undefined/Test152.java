package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/14-12:28
 */
public class Test152 {
    public int maxProduct(int[] nums) {
        int mltp = 1;
        int ans = Integer.MIN_VALUE;
        int min = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                mltp *= nums[i];
                ans = Math.max(ans, mltp/min);
                min = Math.min(min, mltp);
            }else{
                mltp = 1;
                min = 1;
            }


        }

        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-2,-3,0,4};
        int i = maxProduct(nums);
        System.out.println(i);
    }
}

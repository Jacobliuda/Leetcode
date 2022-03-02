package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/2-12:49
 */
public class Test643 {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Double.MIN_VALUE;
        int start = 0;
        int summa = 0;

        for(int end = 0; end < nums.length; end++){
            summa+=nums[end];
            if(end - start + 1 == k){
                ans = Math.max(ans, summa/(double)k);
            }
            if(end >= k-1){
                summa-=nums[start];
                start++;
            }
        }

        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-1};
        int k = 1;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }
}

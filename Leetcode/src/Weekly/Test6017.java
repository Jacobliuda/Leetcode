package Weekly;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author Jacob
 * @creator 2022/3/6-11:01
 */
public class Test6017 {
    public long minimalKSum(int[] nums, int k) {

        long ans = (1L + k) * k / 2;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])   continue;
            if(nums[i] <= k){
                ans = ans + (k + 1) - nums[i];
                k += 1;
            }
        }

        return ans;

    }


    @Test
    public void test(){
        int[] nums = new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84};
        int k = 35;
        long l = minimalKSum(nums, k);
        System.out.println(l);

    }

}

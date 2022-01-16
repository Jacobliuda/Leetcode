package Daily;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/1/12-19:43
 */
public class Test334 {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if(length < 3)
            return false;
        int first = nums[0];
        int second = 2147483647;
        int i = 1;
        while(i < length){
            int num = nums[i];
            if(num > second)
                return true;
            else if(num > first)
                second = num;
            else
                first = num;
            i++;
        }

        return false;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,1,5,0,4,6};
        boolean b = increasingTriplet(nums);
        System.out.println(b);

    }
}

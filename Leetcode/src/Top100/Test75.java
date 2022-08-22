package Top100;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/8/22-20:52
 * @description
 */
public class Test75 {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1;
        for(int i = 0; i <= p2; i++){
            while(i < p2 && nums[i] == 2){
                int tmp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = tmp;
                p2--;
            }
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,2,2,1,1,0,2,2};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

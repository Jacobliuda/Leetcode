package Top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jacob
 * @creator 2022/6/23-15:51
 * @description 移动 0 将 数组中的 0 移动到数组最后面 其他非零数字保持相对顺序不变
 */
public class Test283 {
    public void moveZeroes(int[] nums) {
        int i = 0, idx = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                nums[idx++] = nums[i];
            }
            i+=1;

        }
        while(idx < nums.length){
            nums[idx++] = 0;
        }

    }

    @Test
    public void test(){
        int[] nums = new int[]{0, 3, 0, 1, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

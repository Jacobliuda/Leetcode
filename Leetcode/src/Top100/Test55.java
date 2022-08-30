package Top100;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/8/22-17:16
 * @description
 */
public class Test55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,1,0,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}

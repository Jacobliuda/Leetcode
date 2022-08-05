package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/7/4-21:42
 * @description
 */
public class Test35 {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])    return 0;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(target <= nums[mid]){
                high = mid -1;
            }else
                low = mid + 1;
        }
        return low;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,3,5,6};
        int target = 3;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

}

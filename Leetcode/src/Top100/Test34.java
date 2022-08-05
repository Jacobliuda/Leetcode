package Top100;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/7/5-17:10
 * @description
 */
public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)    return new int[]{-1, -1};

        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if( target <= nums[mid] )
                high = mid;
            else
                low = mid + 1;
        }

        System.out.println(low + " " + high);

        if(nums[low]!=target)   return new int[]{-1, -1};

        int[] ans = new int[2];
        ans[0] = low;
        low = 0;
        high = nums.length-1;

        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if( target >= nums[mid] )
                low = mid;
            else
                high = mid - 1;
        }

        System.out.println(low + " " + high);

        ans[1] = low;
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{7,7,7,8,8,10};

        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

}

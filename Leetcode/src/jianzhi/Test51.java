package jianzhi;

import org.junit.Test;

public class Test51 {
    public int reversePairs(int[] nums) {
        if(nums.length < 2)
            return 0;

        int[] temp = new int[nums.length];
        int ans = reversePairs(nums, 0, nums.length-1, temp);

        for(int i = 0; i < nums.length; i ++)
            System.out.println(nums[i]);

        return ans;
    }


    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right)
            return 0;

        int mid = (right - left) / 2 + left;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for(int i = left; i <= right; i++)
            temp[i] = nums[i];

        int i = left;
        int j = mid + 1;

        int cnt = 0;
        for(int k = left; k <= right; k ++){

            if(i == mid + 1)
                nums[k] = temp[j++];
            else if(j == right + 1)
                nums[k] = temp[i++];
            else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
               nums[k] = temp[j];
               j++;
               cnt += (mid - i + 1);
            }
        }
        return cnt;
    }

    @Test
    public void test(){
        int[] nums = new int[]{7,5,6,4};
        int ans = reversePairs(nums);
        System.out.println(ans);
    }
}

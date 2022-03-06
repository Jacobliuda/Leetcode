package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/6-12:04
 */
public class Sort {
    public void quickSort(int[] nums, int start, int end){
        if(start >= end)
            return;

        int base = nums[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && nums[j] >= base)
                j--;
            while(i < j && nums[i] <= base)
                i++;
            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[start] = nums[i];
        nums[i] = base;

        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    @Test
    public void test(){

        int[] nums = new int[]{78, 12, 33, 1, 898, 32, 100};
        quickSort(nums, 0, 6);
        for (int num : nums) {
            System.out.println(num);

        }

    }
}

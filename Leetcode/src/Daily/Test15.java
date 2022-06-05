package Daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/5/11-11:59
 * @description
 */
public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;

        for(int i = 0; i < length; i++){

            int target = -nums[i];
            if(i > 0 && nums[i] == nums[i-1])   continue;
            if(target < 0)  continue;
            int j = i + 1;
            int k = length - 1;
            while(j < k){
                if(nums[j] + nums[k] == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);

                    while(j < k && nums[j+1] == nums[j])    j++;
                    j++;
                    while(j < k && nums[k-1] == nums[k])    k--;
                    k--;
                }else if(nums[j] + nums[k] < target)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
//            System.out.println("println--------------------");
        }
    }
}

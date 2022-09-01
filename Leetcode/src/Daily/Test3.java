package Daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/8/31-16:36
 * @description
 */
public class Test3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1])   continue;

            int tgt = -nums[i];

            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int cur = nums[j] + nums[k];
                if(cur == tgt){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    ans.add(integers);
                    while(j < k && nums[j+1] == nums[j])    j++;
                    j++;
                    while(j < k && nums[k-1] == nums[k])    k--;
                    k--;
                }
                else if(cur < tgt)
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
            System.out.println();
        }
    }

    @Test
    public void test1(){
        System.out.println(Math.log(100) / Math.log(10));
    }
}

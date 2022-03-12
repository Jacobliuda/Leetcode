package Undefined;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/3/11-15:14
 */
public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if(length < 3)  return res;
        for(int f = 0; f < length-1; f ++){
            if(f > 0 && nums[f]==nums[f-1]) continue;
            int target = -nums[f];
            if(target < 0)  break;
            int s = f + 1, t = length - 1;
            while(s < t){
                if(nums[s] + nums[t] == target){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[f]);
                    integers.add(nums[s]);
                    integers.add(nums[t]);
                    res.add(integers);

                    while( s < t && nums[s+1] == nums[s])   s++;
                    while( s < t && nums[t-1] == nums[t])   t--;
                }else if(nums[s] + nums[t] > target)
                    t--;
                else
                    s++;
            }
        }
        return res;
    }
}

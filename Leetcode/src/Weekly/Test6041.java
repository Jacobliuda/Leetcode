package Weekly;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/4/24-10:34
 * @description
 */
public class Test6041 {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                Integer orDefault = map.getOrDefault(nums[i][j], 0);
                map.put(nums[i][j], orDefault + 1);
                if(i == nums.length - 1){
                    if(orDefault == nums.length-1)
                        ans.add(nums[i][j]);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    @Test
    public void test(){
        int[][] nums = new int[][]{{7,34,45,10,12,27,13},{27,21,45,10,12,13}};
        List<Integer> intersection = intersection(nums);
        Iterator<Integer> iterator = intersection.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}

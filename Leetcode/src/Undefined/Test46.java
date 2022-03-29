package Undefined;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**46. 全排列
 * @author Jacob
 * @creator 2022/3/29-20:34
 * @description
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Test46 {
    List<List<Integer>> lists;
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];

        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, 0, isVisited, path);
        return lists;

    }

    private void dfs(int[] nums, int idx, boolean[] isVisited, ArrayList<Integer> path) {
        int len = nums.length;

        if(idx == len){
            lists.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < len; i++){

            if(!isVisited[i]){
                isVisited[i] = true;
                path.add(nums[i]);
                dfs(nums, idx + 1, isVisited, path);

                path.remove(path.size()-1);
                isVisited[i] = false;
            }

        }


    }


    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }
}

package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacob
 * @creator 2022/8/24-21:27
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {

        // ans 用于记录答案返回
        List<List<Integer>> ans = new ArrayList<>();

        // 首先添加一个空数组作为初始的子集
        ans.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++){

            // 对于每一个新增的元素，让它添加在已存在的 ans 中的每一个数组的后面形成新的数组
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
            for (List<Integer> an : ans) {

                // 原先的数组本来也是子集也需要保留，因此拷贝出来逐个新增新元素
                ArrayList<Integer> copy = new ArrayList<>(an);
                copy.add(nums[i]);

                // 新增完以后加到 新增数组 中
                tmp.add(copy);
            }

            // 对新增数组中的每一个元素，逐个添加到ans中
            for (ArrayList<Integer> integers : tmp)
                ans.add(integers);
        }

        return ans;
    }



    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

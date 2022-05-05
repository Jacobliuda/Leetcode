package Daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 907
 * @author Jacob
 * @creator 2022/4/28-8:34
 * @description 给
 * 你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 *
 * 返回满足此条件的 任一数组 作为答案。
 */
public class Test905 {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            while(i<j && nums[i]%2==0)    i++;
            while(i<j && nums[j]%2==1)    j--;
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {

        // int[] 和 Integer[]的转换
        int[] nums = new int[]{1,2,3,4,5,};
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();

        // int[] 和 ArrayList<Integer> 的转换
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] ints = collect.stream().mapToInt(Integer::intValue).toArray();

        // Integer[] 和 ArrayList<Integer> 的转换
        List<Integer> integers1 = Arrays.asList(integers);
        integers1.toArray(new Integer[integers1.size()]);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{3, 1, 2, 4, 6, 8};
        sortArrayByParity(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

package Daily;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**219 存在重复元素II
 *
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 * @author Jacob
 * @creator 2022/1/19-9:32
 */
public class Test219 {
    /** 哈希表 <nums[i], i>
    逐个扫描数组中的数 如果该数已经在哈希表中存在 则计算与当前索引之差 如果满足条件 返回true  如果不满足条件 修改其索引为当前索引
    若该数不存在 则在哈希表中添加
     时间复杂度 O(n)
     空间复杂度 O(n)
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        if(length == 1)
            return false;
        for(int i = 0; i < length; i++){
            Integer idx = map.get(nums[i]);
            if(idx==null){
                map.put(nums[i], i);
            }else{
                if(i-idx <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
        }
        return false;
    }

    /** 滑动窗口 集合
     固定长度为 k 的滑动窗口 逐个添加数组中的数 当添加失败时 说明已满足条件 返回 true 如果遍历到末尾也不满足 则返回 false
     注意 当索引超过 k 的时候 需要删除最前面的元素
     时间复杂度 O(n)
     空间复杂度 O(k)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(i > k)
                set.remove(nums[i-k-1]);
            boolean add = set.add(nums[i]);
            if(!add)
                return true;
            
        }
        return false;
    }

    //测试第一种方法
    @Test
    public void test1(){
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        boolean ans = containsNearbyDuplicate1(nums, k);
        System.out.println(ans);
    }

    //测试第二种方法
    @Test
    public void test2(){
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        boolean ans = containsNearbyDuplicate2(nums, k);
        System.out.println(ans);
    }


}

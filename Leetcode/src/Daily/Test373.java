package Daily;

import org.junit.Test;

import java.util.*;

/**373. 查找和最小的 K 对数字
 *
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
 *
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 *
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 *
 *
 * @author Jacob
 * @creator 2022/1/14-21:49
 */
public class Test373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            heap.add(new int[]{i, 0});
        }

        while(k-- > 0 && !heap.isEmpty()){
            int[] ind = heap.poll();
            lists.add(Arrays.asList(new Integer[]{nums1[ind[0]], nums2[ind[1]]}));
            if(++ind[1] < nums2.length)
                heap.add(ind);
        }
        return lists;


    }

    @Test
    public void test(){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        int k = 3;
        List<List<Integer>> lists = kSmallestPairs(nums1, nums2, 3);
        Iterator<List<Integer>> iterator = lists.iterator();
        while(iterator.hasNext()){
            List<Integer> next = iterator.next();
            Iterator<Integer> iterator1 = next.iterator();
            while(iterator1.hasNext())
                System.out.print(iterator1.next() + " ");
            System.out.println();
        }

    }
}

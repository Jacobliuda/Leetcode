package Undefined;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jacob
 * @creator 2022/3/22-13:51
 */
public class Test128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int length = 1 + left + right;
                maxLength = Math.max(maxLength, length);

                map.put(num, length);
                map.put(num - left, length);
                map.put(num + right, length);
            }
        }
        return maxLength;
    }


    @Test
    public void test() {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(nums);
        System.out.println(i);

    }
}

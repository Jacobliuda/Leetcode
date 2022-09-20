package Undefined;

import org.junit.Test;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/3/19-19:19
 */
public class Test300 {
    public int lengthOfLISV2(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        if(nums.length == 0)    return 0;
        dp.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            if(num > dp.get(dp.size()-1))
                dp.add(num);
            else{
                int idx = Collections.binarySearch(dp, num);
                if(idx < 0)
                    idx = -idx -1;
                dp.set(idx, num);
            }
        }
        return dp.size();
    }

    @Test
    public void test(){
        int[] nums = new int[]{10,9,2,5,6,3,7,101,18};
//        int i = lengthOfLIS(nums);
//        System.out.println(i);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(6);
        integers.add(8);
        integers.add(10);
        integers.add(12);
        System.out.println(Collections.binarySearch(integers, 14));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxAns = 1;

        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }

    @Test
    public void test2(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    // 判断s1 是否包含 s2
    public boolean contains(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s1.toCharArray();
        for (char c : array) {
            int d = map.getOrDefault(c, 0);
            map.put(c, d + 1);
        }

        array = s2.toCharArray();
        for (char c : array) {
            int d = map.getOrDefault(c, -1);
            if(d < 0)  return false;

            if(d == 1)  map.remove(c);
            else map.put(c, d-1);
        }
        return true;
    }

    @Test
    public void test3(){
        System.out.println(contains("abc", "ac"));
    }
}

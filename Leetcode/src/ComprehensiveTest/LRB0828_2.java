package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/8/28-16:50
 * @description
 */
public class LRB0828_2 {
    public static void main(String[] args) {

        // 处理输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
//        TreeSet<Integer> set = new TreeSet<>();
//        for(int i = 0; i < n; i++)
//            set.add(sc.nextInt());
//
//        long[] nums = new long[set.size()];
//        int idx = 0;
//        for (Object o : set.toArray()) {
//            nums[idx++] = (Integer)o;
//        }

        long[] nums = new long[n];
        for(int idx = 0; idx < n; idx++)
            nums[idx] = sc.nextLong();

        Arrays.sort(nums);

        int ans = 0;
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i-1; j >= 0; j--){
                if(nums[i]*nums[j] >= k)
                    ans += 2;
            }
        }

        System.out.println(ans);


    }
}

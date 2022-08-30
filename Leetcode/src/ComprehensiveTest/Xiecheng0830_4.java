package ComprehensiveTest;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/30-19:51
 * @description
 */
public class Xiecheng0830_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];

        // 构造输入数组
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] > max){
                max = Math.abs(nums[i] - nums[i-1]);
                idx = i;
            }
        }

        if(idx == 1){
            nums[0] = nums[1];
        }else{
            nums[idx-1] = (nums[idx] + nums[idx-2]) / 2;
        }

        int res = 0;
        for(int i = 1; i < n; i++){
            if(Math.abs(nums[i] - nums[i-1]) > res){
                res = Math.abs(nums[i] - nums[i-1]);
            }
        }
        System.out.println(res);
    }
}

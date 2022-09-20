package ComprehensiveTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/14-19:45
 * @description
 */
public class HuaWei0914_2 {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)  nums[i] = sc.nextInt();

        int s = sc.nextInt();
        int ans = 0;

        int idx = 0;
        while(idx < s){
            int tgt = sc.nextInt();
            int i = 0, j = n - 1;
            while(i < j){

                int num = nums[i] + nums[j];
                if(num < tgt)   i++;
                else if(num > tgt)  j--;
                else{
                    ans += 1;
                    i ++;
                    j --;

                }
            }
            idx++;
        }

        System.out.println(ans);

    }
}

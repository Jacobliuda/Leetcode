package ComprehensiveTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/23-19:36
 * @description
 */
public class Leihuo0423_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < num; i++){
            String[] s = sc.nextLine().split(" ");
            int total = Integer.parseInt(s[0]);
            int low = Integer.parseInt(s[1]);
            int high = Integer.parseInt(s[2]);
            int skillCnt = Integer.parseInt(s[3]);

            String[] s1 = sc.nextLine().split(" ");
            int[] power = new int[s1.length];
            for(int j = 0; j < s1.length; j++)
                power[j] = Integer.parseInt(s1[j]);

            int ans = func(total, low, high, power, power.length-1, 0);
            System.out.println(ans);
        }
    }

    private static int func(int cur, int low, int high, int[] power, int idx, int cnt) {
        // 如果已经满足在区间内 返回当前 cnt
        if(cur >= low && cur <= high)
            return cnt;

        //
        if(idx < 0 && cur < low)
            return 0;

        if(cur > high){
            return func(cur - power[idx], low, high, power, idx, cnt + 1);
        }
        return func(cur + power[idx], low, high, power, idx - 1, cnt - 1);
    }
}

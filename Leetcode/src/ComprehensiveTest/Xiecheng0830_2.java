package ComprehensiveTest;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/30-19:09
 * @description
 */
public class Xiecheng0830_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){
            int y = sc.nextInt();
            int o = sc.nextInt();
            int u = sc.nextInt();
            int ans = 0;

            int db_cnt = Math.min(y, Math.min(o, u));
            ans += 2 * db_cnt;
            y -= db_cnt;
            o -= db_cnt;
            u -= db_cnt;

            if(o >= 2){
                int sg_cnt = o - 1;
                ans += sg_cnt;
            }
            System.out.println(ans);
        }
    }
}

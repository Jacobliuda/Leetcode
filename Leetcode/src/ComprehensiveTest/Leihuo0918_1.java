package ComprehensiveTest;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/18-19:15
 * @description
 */
public class Leihuo0918_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int total_cnt = 0;

        int idx = 0;
        while(idx++ < n){
            String[] s = sc.nextLine().split(" ");
            int cnt = fun1(s[0], s[1]);
            total_cnt += cnt;
        }

        double ans = (double)total_cnt / (10 * n);
        System.out.printf("%.2f", ans * 100);
        System.out.print("%");
    }

    private static int fun1(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int score = 0;
        if(s1.charAt(0) == s2.charAt(0))
            score += 2;
        if(s1.substring(1, n1-5).equals(s2.substring(1, n2-5)))
            score += 3;

        score += fun2(s1.substring(n1-5, n1), s2.substring(n2-5));

        return score;
    }

    private static int fun2(String s1, String s2){
        int[][] dp = new int[6][6];
        int ans = 0;
        for(int i = 4; i >= 0; i--){
            for(int j = 4; j >= 0; j--){
                dp[i][j] = s1.charAt(i) == s2.charAt(j) ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(fun2("88688", "B6868"));
    }
}

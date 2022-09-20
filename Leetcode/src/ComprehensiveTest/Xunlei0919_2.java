package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/19-20:45
 * @description
 */
public class Xunlei0919_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] nums = new int[s.length];
        for(int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(s[i]);

        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i < n+1; i ++){
            for(int j = i; j < n+1; j++){
                dp[i][j] = dp[i][j-1] + nums[j-1];
            }
        }
    }
}

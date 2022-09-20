package ComprehensiveTest;

import java.util.*;
import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/9/7-19:42
 * @description
 */
public class Qunar0907_1 {
    public int maxScore (int energy, int[][] actions) {
        // write code here
        int m = actions.length;
        int n = actions[0].length;
        int[] weights = new int[actions.length];
        for(int i = 0; i < actions.length; i++) weights[i] = actions[i][0];
        int[] values = new int[actions.length];
        for(int i = 0; i < actions.length; i++) values[i] = actions[i][0];

        int[][] dp = new int[m+1][energy+1];
        dp[0][0] = 0;

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= actions[i][0]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-actions[i][0]] + actions[i][1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][energy];
    }

    @Test
    public void test(){
        int energy = 10;
        int[][] actions = new int[][]{{1,1},{2,3},{3,5},{5,10},{7,9},{8,10}};
        int ans = maxScore(energy, actions);
        System.out.println(ans);
    }
}

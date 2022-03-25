package Undefined;

import org.junit.Test;

import javax.jnlp.IntegrationService;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Jacob
 * @creator 2022/3/25-12:07
 */
public class Test322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i < dp.length; i++)  dp[i] = amount + 1;
        dp[0] = 0;
        for(int cnt = 1; cnt < dp.length; cnt++){
            for(int i = 0; i < coins.length; i++) {
                int target = cnt - coins[i];
                if (target >= 0)
                    dp[cnt] = Math.min(dp[cnt], dp[target] + 1);
            }

        }
        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }

    @Test
    public void test(){
        int[] coins = new int[]{2,5};
        int i = coinChange(coins, 3);
        System.out.println(i);
    }
}

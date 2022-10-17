package jianzhi;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/9/24-10:38
 * @description
 */
public class Offer2_103 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    @Test
    public void test(){
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);

    }
}

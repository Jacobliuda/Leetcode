package Daily;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/4/25-20:38
 * @description
 */
public class Test322 {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for(int i = 1; i < amount + 1; i++) dp[i] = amount + 1;

            for(int i = 1; i < amount + 1; i++){
                for(int j = 0; j < coins.length; j++){
                    int target = i - coins[j];
                    if(target >= 0)
                        dp[i] = Math.min(dp[i], dp[target] + 1);
                }
            }
            return dp[amount] < amount + 1 ? dp[amount] : -1;
        }

    @Test
    public void test(){
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}

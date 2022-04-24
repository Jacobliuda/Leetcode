package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/20-20:49
 */
public class BagProblem {
    public void solve(int[] volume, int[] value, int target){
        int length = volume.length;

        // 定义dp数组 dp[i][j] 表示当背包容量为 j 时 考虑前 i 个物品的最大价值
        int[][] dp = new int[length+1][target+1];

        // 对边界条件进行初始化
        for(int j = 0; j < dp.length; j++)
            dp[j][0] = 0;
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;

        // 开始构造 dp
        for(int i = 1; i < dp.length; i++){
            // 取出当前物品的重量和
            int cur_volume = volume[i-1];
            int cur_value = value[i-1];
            for (int j = 1; j < dp[0].length; j++){


                // 考虑装入当前物品的最大价值
                // 若装入 需预留多少空间
                int space = j - cur_volume;

                // 若装不下 则跟 dp[i-1][j]情况相同
                if(space < 0){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                // 若能装下 则装入 同时扣减对应容量 去除彼时能装的最大容量
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][space] + cur_value);
            }
        }

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }

    @Test
    public void test(){
        int[] volume = new int[]{5,1,4,3};
        int[] values = new int[]{40,10,25,30};
        int target = 10;
        solve(volume, values, target);
    }
}

package Daily;

import org.junit.Test;

/**1220. 统计元音字母序列的数目
 *
 * 给你一个整数n，请你帮忙统计一下我们可以按下述规则形成多少个长度为n的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音'a'后面都只能跟着'e'
 * 每个元音'e'后面只能跟着'a'或者是'i'
 * 每个元音'i'后面不能 再跟着另一个'i'
 * 每个元音'o'后面只能跟着'i'或者是'u'
 * 每个元音'u'后面只能跟着'a'
 * 由于答案可能会很大，所以请你返回 模10^9 + 7之后的结果。
 *
 *
 * @author Jacob
 * @creator 2022/1/18-19:43
 */
public class Test1220 {
    int[][] graph = new int[][]{{0,1,0,0,0}, {1,0,1,0,0},{1,1,0,1,1},{0,0,1,0,1},{1,0,0,0,0}};

    public int countVowelPermutation(int n) {
        int[][] dp = new int[n+1][5];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 5; j++){
                if(i==1)
                    dp[i][j] = 1;
                else{
                    int t = 0;
                    for(int k = 0; k < 5; k++){
                        if(graph[k][j]>0)
                            t = (t+dp[i-1][k])%1000000007;
                    }
                    dp[i][j] = t;
                }
            }
        }
        int ans = 0;
        for(int num:dp[n])
            ans = (ans + num)%1000000007;
        return ans;
    }

    @Test
    public void test(){
        int ans = countVowelPermutation(158);
        System.out.println(ans);
    }
}

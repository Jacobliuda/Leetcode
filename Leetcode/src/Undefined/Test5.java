package Undefined;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/3/18-15:47
 */
public class Test5 {
    public String longestPalindrome(String s) {
        int length = s.length();

        // dp[i][j] 表示字符串从位置 i 到 j 最长的回文字符串长度
        int[][] dp = new int[length][length];
        for(int i = 0; i < length; i++) dp[i][i] = 1;

        // 开始按长度遍历
        for(int l = 2; l <= length; l++){
            for(int i = 0; i <= length - l; i++){
                int j = i + l - 1;
                if(s.charAt(i) != s.charAt(j))
                    dp[i][j] = 0;
                else{
                    if(l <= 3)
                        dp[i][j] = l;
                    else
                        dp[i][j] = dp[i+1][j-1] + 2;
                }
            }
        }

        String str = new String();
        int max = 0;
        for(int i = 0; i < length; i ++){
            for(int j = 0; j < length; j++){
                if(dp[i][j] > max){

                    max = dp[i][j];
                    str = s.substring(i, j+1);
                }
            }
        }
        return str;
    }

    @Test
    public void test(){
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);


    }
}

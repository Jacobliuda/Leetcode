package Daily;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/8/30-21:41
 * @description
 */
public class Test5 {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n < 2)
            return s;

        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;
        int begin = 0;

        // 按照子字符串长度枚举
        for(int len = 2; len <= n; len++){
            for(int start = 0; start < n; start++){
                int end = start + len - 1;
                if(end >= n) break;

                // 若子串首尾字符不相同，子串必不会是回文字符串
                if(s.charAt(start) != s.charAt(end))    dp[start][end] = false;
                else{

                    if(end - start < 3)
                        dp[start][end] = true;
                    else
                        dp[start][end] = dp[start + 1][end - 1];

                }

                if(dp[start][end] && len > maxLen){
                    begin = start;
                    maxLen = len;
                }
            }
        }

        return s.substring(begin, begin + maxLen);

    }

    @Test
    public void test(){
        String s = "ac";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
}

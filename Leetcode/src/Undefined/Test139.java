package Undefined;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jacob
 * @creator 2022/9/3-17:10
 * @description
 */
public class Test139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                boolean left = dp[j];
                String substring = s.substring(j, i);
                boolean right = set.contains(substring);
                if(dp[j] && right){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    @Test
    public void test(){
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<>();
        for (String s1 : new String[]{"leet", "code"}) {
            wordDict.add(s1);
        }

        boolean b = wordBreak(s, wordDict);
        System.out.println(b);

        System.out.println("hello".substring(0, 3));

    }
}

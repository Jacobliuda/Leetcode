package ComprehensiveTest;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/4/7-19:09
 * @description
 */
public class TME0407_1 {
    public int minCnt(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(i==0)    continue;
            if(s.charAt(i)=='1')    ans++;
        }
        return ans;
    }

    @Test
    public void test() {
        String s = new String("1001001111111111110");
        int i = minCnt(s);
        System.out.println(i);
    }
}

package jianzhi;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/5/6-10:20
 * @description
 */
public class Offer43 {
    public int countDigitOne(int n) {
        int base = 1;
        int ans = 0;
        while(base <= n){
            int high = n / base / 10;
            int low = n % base;
            int cur = n / base % 10;
            if(cur == 0)
                ans += high * base;
            else if(cur == 1)
                ans = ans + high * base + low + 1;
            else
                ans += (high + 1) * base;
            base *= 10;
        }

        return ans;
    }

    @Test
    public void test(){
        int n = 100;
        int i = countDigitOne(n);
        System.out.println(i);
    }
}

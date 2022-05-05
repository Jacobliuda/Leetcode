package jianzhi;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/5/5-22:04
 * @description
 */
public class Offer14 {
    public int cuttingRope(int n) {

        if(n == 2)  return 1;
        if(n == 3)  return 2;

        int a = n / 3;
        int b = n % 3;
        int P = 1000000007;

        long ans = 1;

        for(int i = 1; i < a; i++)
            ans = ans * 3 % P;

        if(b == 0)  ans = ans * 3;
        else if(b == 1) ans = ans * 4;
        else    ans = ans * 6;
        return (int)(ans % 1000000007);
    }

    @Test
    public void test(){
        int i = cuttingRope(127);
        System.out.println(i);
    }
}

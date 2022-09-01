package ComprehensiveTest;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/31-16:51
 * @description
 */
public class SF0831_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long ans = 0;

        int e = 1;
        while(Math.pow(2, e) <= n){
            ans += e * Math.pow(2, e - 1);
            e++;
        }

        ans += e * (n - Math.pow(2, e-1) + 1);

        System.out.println(ans);
    }


    @Test
    public void test(){
        System.out.println(8 >= 7.9);
    }
}

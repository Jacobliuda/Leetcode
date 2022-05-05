package Daily;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/5/5-21:13
 * @description
 */
public class Fibo {
    public int fibonacci(int first, int second, int n){
        if(n<=0)
            return 0;
        if(n < 3)
            return 1;
        else if(n == 3)
            return first + second;
        else
            return fibonacci(second, first + second, n - 1);
    }

    @Test
    public void test(){
        int fibonacci = fibonacci(1, 1, 5);
        System.out.println(fibonacci);
    }
}

package Daily;

import org.junit.Test;

/**Test1716
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1块钱。从周二到周日，他每天都比前一天多存入 1块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1块钱。
 *
 * 给你n，请你返回在第 n天结束的时候他在力扣银行总共存了多少块钱。
 *
 * @author Jacob
 * @creator 2022/1/15-13:41
 */
public class Test1716 {
    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        int ans = 0;
        if(a > 0)
            ans += (28 * a + 7 * a * (a - 1) / 2);
        ans += (1 + 2 * a + b) * b / 2;
        return ans;


    }

    @Test
    public void test(){
        System.out.println(totalMoney(4));
    }
}

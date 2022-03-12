package Undefined;

import org.junit.Test;

/**整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jacob
 * @creator 2022/3/12-14:33
 */
public class Test7 {
    public int reverse(int x) {
        int ans = 0;
        boolean flag = true;
        if(x < 0){
            x = -1 * x;
            flag = false;
        }
        while ( x > 0 ){
            if(ans > 214748364 || (ans == 214748364 && flag && x > 7 ) || (ans == 214748364 && !flag && x > 8 ))
                return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return flag?ans:ans*(-1);
    }

    @Test
    public void test(){
        int s = -21474836;
        int reverse = reverse(s);
        System.out.println(reverse);
    }
}

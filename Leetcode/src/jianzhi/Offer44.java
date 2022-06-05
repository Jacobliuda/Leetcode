package jianzhi;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/5/6-11:04
 * @description
 */
public class Offer44 {
    public int findNthDigit(int n) {
        // start表示每个位数最小的数
        // digits是位数计数器
        long start = 1;
        int digits = 1;

//        判断 n 属于哪一个位数区间
        while (n > 9 * start * digits) {
            n -= 9 * start * digits;
            start *= 10;
            digits += 1;
        }

        // 计算出属于哪一个数字
        long num = start + (n-1) / digits;
        int idx = (n - 1) % digits;
        int ans = String.valueOf(num).charAt(idx) - '0';
        return ans;
    }

    @Test
    public void test(){

        int n = 15;
        int nthDigit = findNthDigit(n);
        System.out.println(nthDigit);

    }
}

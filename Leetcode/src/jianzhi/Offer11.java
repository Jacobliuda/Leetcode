package jianzhi;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/4/28-19:51
 * @description
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (numbers[m] < numbers[r])
                r = m;
            else if (numbers[m] > numbers[r])
                l = m + 1;
            else
                r -= 1;
        }
        return numbers[l];
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 4, 5, 1, 2};
        int i = minArray(nums);
        System.out.println(i);
    }
}

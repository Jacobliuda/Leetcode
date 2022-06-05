package jianzhi;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/5/7-16:57
 * @description
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        int[] c = new int[a.length];
        int[] ans = new int[a.length];
        Arrays.fill(b, 1);
        Arrays.fill(c, 1);
        for(int i = 1; i < a.length; i++)
            b[i] = b[i-1] * a[i-1];
        for(int j = a.length - 2; j >= 0; j--)
            c[j] = c[j+1] * a[j+1];
        for(int i = 0; i < ans.length; i++)
            ans[i] = b[i] * c[i];
        return ans;
    }

    @Test
    public void test(){
        int[] a = new int[]{1,2,3,4,5};
        int[] ints = constructArr(a);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

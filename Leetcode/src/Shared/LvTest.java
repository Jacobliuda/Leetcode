package Shared;

import org.junit.Test;

/**
 * @author Jacob
 * @creator 2022/5/26-10:05
 * @description
 */
public class LvTest {
    public static void main(String[] args) {

    }

    public void testAddOperation() {
        byte i = 15;
        int j = 8;
        int k = i + j;
    }

    @Test
    public void testSelfAdd() {
        int i1 = 10;
        i1++;

        int i2 = 10;
        ++i2;

        int i3 = 10;
        int i4 = i3++;
        System.out.println(i4);

        int i5 = 10;
        int i6 = ++i5;
        System.out.println(i5);

        int i7 = 10;
        i7 = i7++;
        System.out.println(i7);

        int i8 = 10;
        i8 = ++i8;
        System.out.println(i8);

        int i9 = 10;
        int i10 = i9++ + ++i9;
        System.out.println(i9);
    }


}

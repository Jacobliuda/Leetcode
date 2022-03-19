package Undefined;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jacob
 * @creator 2022/3/18-13:40
 */
public class Test415 {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1, j = chars2.length - 1;
        int add = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 || j >= 0 || add > 0){
            int x = i >= 0 ? chars1[i] - '0' : 0;
            int y = j >= 0 ? chars2[j] - '0' : 0;
            add = x + y + add;
            builder.append(add % 10);
            add /= 10;
            i--;
            j--;
        }

        return builder.reverse().toString();
    }

    @Test
    public void test(){
        String num1 = "456", num2 = "77";
        String s = addStrings(num1, num2);
        System.out.println(s);
    }

}

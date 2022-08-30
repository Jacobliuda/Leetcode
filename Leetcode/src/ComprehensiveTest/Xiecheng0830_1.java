package ComprehensiveTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static ComprehensiveTest.mt_5.func;

/**
 * @author Jacob
 * @creator 2022/8/30-19:07
 * @description
 */
public class Xiecheng0830_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){
            int num = sc.nextInt();
            System.out.println(func(num));
        }

    }

    private static int func(int num) {
        if(num % 2 == 0)    return num;

        ArrayList<Integer> characters = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            characters.add(digit);
            num /= 10;

            if(digit % 2 == 0){
                int i = 0;
                int renum = num;
                while(i < characters.size()){
                    renum = renum * 10 + characters.get(i++);
                }
                return renum;
            }
        }

        return -1;

    }

}

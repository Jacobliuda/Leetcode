package ComprehensiveTest;

import java.util.Scanner;
import org.junit.Test;


/**
 * @author Jacob
 * @creator 2022/8/27-19:58
 * @description
 */
public class jd0827_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        char[] array = sc.nextLine().toCharArray();

        for(int i = 0; i < k; i++){
            char ch = array[i];
            if(ch >= 'a' && ch <= 'z'){
                ch -= 32;
            }
            System.out.print(ch);

        }
        for(int i = k; i < n; i++){
            char ch = array[i];
            if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
//                array[i] = ch;
            }
            System.out.print(ch);

        }

//        for(int i = 0; i < n; i++)
//            System.out.println(array[i]);

    }

    @Test
    public void test(){
        System.out.println((int)'A');
    }
}

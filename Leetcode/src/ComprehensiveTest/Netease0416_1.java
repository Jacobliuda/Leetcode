package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/16-15:22
 * @description
 */
public class Netease0416_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i > 0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j ++)
                sb.append(".");
            for(int j = i; j < 4 * n - i; j ++)
                sb.append("*");
            for(int j = 4 * n - i; j < 4 * n; j ++)
                sb.append(".");
            System.out.println(sb);
        }

        for(int i = 0; i <= 2 * n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j ++)
                sb.append("*");
            for(int j = n; j < 3*n; j++)
                sb.append(".");
            for(int j = 3*n; j < 4*n; j++)
                sb.append("*");
            System.out.println(sb);
        }

        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j ++)
                sb.append(".");
            for(int j = i; j < 4 * n - i; j ++)
                sb.append("*");
            for(int j = 0; j < i; j ++)
                sb.append(".");
            System.out.println(sb);
        }


    }
}

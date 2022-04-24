package Undefined;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/2-16:21
 * @description
 */
public class Unqualified_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        String[] zhuyu = new String[n1];
        String[] weiyu = new String[n2];
        String[] bingyu = new String[n3];
        for (int i = 0; i < n1; i++) {
            zhuyu[i] = scanner.next();
        }
        for (int i = 0; i < n2; i++) {
            weiyu[i] = scanner.next();
        }
        for (int i = 0; i < n3; i++) {
            bingyu[i] = scanner.next();
        }


        int m = scanner.nextInt();
        while(scanner.hasNext()){
            for(int i = 0; i < m; i++){
                String s = scanner.nextLine();
                System.out.println(s);
//                String[] ss = s.split(" ");
//                process(s);
            }
        }
    }

    public static void process(String[] arr){

    }
}

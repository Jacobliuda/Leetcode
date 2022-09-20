package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/19-20:35
 * @description
 */
public class Xunlei0919_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int tgt = Integer.parseInt(split[0]);
        int maxDoubles = Integer.parseInt(split[1]);

        int cnt = 0;
        while(tgt > 1){

            while(tgt > 1 && tgt % 2 == 0 && maxDoubles > 0){
                tgt /= 2;
                maxDoubles --;
                cnt ++;
            }

            if(tgt > 1 && (tgt % 2 == 1 || maxDoubles == 0)){
                tgt -= 1;
                cnt ++;
            }

        }
        System.out.println(cnt);
    }
}

package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/6/26-19:04
 * @description
 */
public class Huatai_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] array = new int[26];
        while(true){
            array[i] = sc.nextInt();
            i++;
            if(i == 26)
                break;
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, array[0]/2);
        ans = Math.min(ans, array[7]);
        ans = Math.min(ans, array[8]);
        ans = Math.min(ans, array[19]);
        ans = Math.min(ans, array[20]);
        System.out.println(ans);
    }
}

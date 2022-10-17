package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/10/9-19:29
 * @description
 */
public class citicbank1009_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];

        for(int i = 0; i < n; i ++){
            int j = 0;
            while(j < n)
                array[i][j++] = sc.nextInt();
        }

        for(int i = 0; i < n/2; i++){
            int[] tmp = array[i];
            array[i] = array[n-1-i];
            array[n-1-i] = tmp;
        }

        for(int j = 0; j < n/2; j++){
            for(int i = 0; i < n; i++){
                int tmp = array[i][j];
                array[i][j] = array[i][n-1-j];
                array[i][n-1-j] = tmp;
            }
        }

        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}

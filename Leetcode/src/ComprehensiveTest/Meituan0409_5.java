package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/9-17:43
 * @description
 */
public class Meituan0409_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n_ori = sc.nextInt();
        sc.nextLine();
        String[] s1 = sc.nextLine().split(" ");
        char[] ori = new char[n_ori];

        for(int i = 0; i < n_ori; i++)
            ori[i] = s1[i].charAt(i);

        int n_tar = sc.nextInt();
        sc.nextLine();
        String[] s2 = sc.nextLine().split(" ");
        char[] tar = new char[n_tar];

        for(int i = 0; i < n_tar; i++)
            ori[i] = s2[i].charAt(i);

        int idx1 = 0;
        int idx2 = 0;

    }
}

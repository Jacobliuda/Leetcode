package ComprehensiveTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/27-14:47
 * @description
 */
public class Test360_1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] ex_scores = new int[n];

        for(int i = 0; i < n; i++)
            ex_scores[i] = sc.nextInt();

        Arrays.sort(ex_scores);
        int idx = n-1;
        int pfmc = 100;
        while(true){
            if(idx != n-1 && ex_scores[idx] != ex_scores[idx+1])    pfmc--;

            if( p*pfmc + q*ex_scores[idx] < 6000)
                break;
            idx--;
            if(idx < 0)
                break;
        }

        System.out.println(n-idx-1);
    }
}

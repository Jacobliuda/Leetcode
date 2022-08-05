package ComprehensiveTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/7/17-20:52
 * @description
 */
public class ByteCamp2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> distance = new ArrayList<>();

        int i = 1;
        while(i < n){
            distance.add(sc.nextInt());
            i ++;
        }

        Collections.sort(distance);

        while(m <= 0 || distance.size() <= 1){

            int tmp = distance.get(0) + distance.get(1);
            distance.remove(0);
            distance.remove(1);
            distance.add(tmp);
            m -= 1;
        }

        System.out.println(distance.get(0));

    }
}

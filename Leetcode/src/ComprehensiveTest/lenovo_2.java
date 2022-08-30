package ComprehensiveTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/16-15:43
 * @description
 */
public class lenovo_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashSet<String> set = new HashSet<>();
        while(n-- > 0){
            String[] s = sc.nextLine().split(" ");
            for (String s1 : s) {
                set.add(s1);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            if(sb.length() + s.length() > 50){
                System.out.println(sb);
                sb.setLength(0);
            }
            sb.append(s + " ");
        }
        System.out.println(sb);
    }
}

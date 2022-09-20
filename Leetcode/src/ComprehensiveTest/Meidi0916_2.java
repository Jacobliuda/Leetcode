package ComprehensiveTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/16-16:17
 * @description
 */
public class Meidi0916_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(n-- > 0){
            String s = sc.nextLine();
            System.out.println(fun(s));
        }
    }

    private static int fun(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] ss = s.split(" ");
        int total = ss.length;
        for (String s1 : ss) {
            int key = Integer.parseInt(s1);
            int cnt = map.getOrDefault(key, 0);
            if(cnt + 1 >= (total + 1) / 2)
                return key;
            map.put(key, cnt + 1);
        }
        return -1;
    }
}

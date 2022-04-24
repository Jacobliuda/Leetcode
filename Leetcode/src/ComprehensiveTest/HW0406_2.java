package ComprehensiveTest;

/**
 * @author Jacob
 * @creator 2022/4/6-20:06
 * @description
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW0406_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, int[]> map = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < 2 * m; i++) {
            String[] words = sc.nextLine().split("");
            for (int j = 0; j < words.length; j++) {
                if (map.containsKey(words[j])) {

                } else {
                    map.put(words[j], new int[]{i % 2 == 0 ? j : Integer.MAX_VALUE, i % 2 == 0 ? 3 : 0, i % 2 == 0 ? Integer.MAX_VALUE : j, i % 2 == 0 ? 0 : 1});
                }
            }
        }
    }
}
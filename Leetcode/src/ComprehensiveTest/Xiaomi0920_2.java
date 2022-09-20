package ComprehensiveTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/9/20-19:13
 * @description
 */
public class Xiaomi0920_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) - 1);

        int cnt = 0;
        for (char c : s.toCharArray()) {
            cnt += Math.abs(map.get(c));
        }

        System.out.println(cnt);

    }
}

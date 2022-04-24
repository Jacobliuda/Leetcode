package Undefined;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/2-15:56
 * @description
 */
public class DNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < chars1.length; i ++){
            if(chars1[i]!=chars2[i]){
                Integer orDefault = map.getOrDefault(chars1[i], 0);
                map.put(chars1[i], orDefault+1);
            }
        }
        int cnt_a = map.get('A');
        int cnt_t = map.get('T');
        int ans = cnt_a == cnt_t ? 0: Math.max(cnt_a, cnt_t);
        System.out.println(ans);
    }
}

package ComprehensiveTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/4/14-19:14
 * @description
 */
public class Xiecheng0414_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer[]> map = new HashMap<>();
        String[] s = sc.nextLine().split(" ");
        String ss = sc.nextLine();
        for(int i = 0; i < s.length; i++){
            int key = Integer.parseInt(s[i]);
            char c = ss.charAt(i);
            if(!map.containsKey(key))
                map.put(key, new Integer[]{0, 0});
            if(c=='B')
                map.get(key)[0] += 1;
            else
                map.get(key)[1] += 1;
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            Integer[] value = entry.getValue();
            if(value[0] > 0 && value[1] > 0)
                ans += value[0] * value[1];
        }
        System.out.println(ans);

    }
}

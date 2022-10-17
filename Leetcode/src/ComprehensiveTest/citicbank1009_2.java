package ComprehensiveTest;

import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/10/9-19:23
 * @description
 */
public class citicbank1009_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int[] array = new int[26];
        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            array[ch - 97] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(array[i] >= 2)
                sb.append((char)(i+97));
        }

        System.out.println(sb);
    }
}

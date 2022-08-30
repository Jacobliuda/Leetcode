package ComprehensiveTest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Jacob
 * @creator 2022/8/27-15:03
 * @description
 */
public class Test360_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ns = new int[3];
        int idx = 0;
        for (String s : sc.nextLine().split(" "))
            ns[idx++] = Integer.parseInt(s);

        HashSet<String> set0 = new HashSet<>();
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        for (String s : sc.nextLine().split(" "))
            set0.add(s);
        for (String s : sc.nextLine().split(" "))
            set1.add(s);
        for (String s : sc.nextLine().split(" "))
            set2.add(s);

        int num = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while(i++ < num){
            String[] words = sc.nextLine().split(" ");
            // 如果总长度小于三 句子长度不完整 或者谓语出现在句首 直接判错
            if(words.length < 3 || set1.contains(words[0])){
                System.out.println("NO");
                continue;
            }

            int cnt0 = 0, cnt1 = 0;
            for(String word: words){
                if(set0.contains(word) || set2.contains(word))
                    cnt0++;
                if(set1.contains(word))
                    cnt1++;
            }

            if(cnt1 > 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }

}

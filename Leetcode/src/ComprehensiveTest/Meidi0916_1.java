package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/9/16-15:59
 * @description
 */
public class Meidi0916_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        TreeSet<String> set = new TreeSet<>();
        for (String s1 : s.split(","))
            set.add(s1);

        Iterator<String> iterator = set.iterator();

        StringBuilder sb = new StringBuilder();
        while(iterator.hasNext()){
            sb.append(iterator.next());
            sb.append(",");
        }
        System.out.println(sb.toString().substring(0, sb.length()-1));


    }
}
